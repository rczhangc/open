package org.open.boot.dao.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.open.boot.dao.goods.GoodsSkuValueManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuBO;
import org.open.boot.dao.goods.business.GoodsSkuValueBO;
import org.open.boot.dao.goods.entity.GoodsSkuValueDO;
import org.open.boot.util.CheckUtil;
import org.open.boot.util.CodeUtil;
import org.open.boot.util.CopyUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 商品规格值信息表服务实现类
 *
 * @author barnak
 */
@Repository
class GoodsSkuValueManagerImpl extends ServiceImpl<GoodsSkuValueMapper, GoodsSkuValueDO> implements GoodsSkuValueManager {

    @Override
    public List<GoodsSkuValueDO> getGoodsSkuValueList(GoodsBO goods) {
        List<GoodsSkuBO> requestGoodsSkuList = goods.getGoodsSkuList();
        CheckUtil.checkIf(CollectionUtils.isEmpty(requestGoodsSkuList), "商品规格信息不存在");
        // 将请求中的所有规格值取出一起校验
        List<GoodsSkuValueBO> goodsAllSkuValueList = new ArrayList<>();
        for (GoodsSkuBO requestGoodsSku : requestGoodsSkuList) {
            List<GoodsSkuValueBO> goodsSkuValueList = requestGoodsSku.getGoodsSkuValueList();
            CheckUtil.checkIf(CollectionUtils.isEmpty(goodsSkuValueList), "商品规格值不能为空");
            goodsSkuValueList.forEach(o -> o.setSkuNamed(requestGoodsSku.getNamed()));
            goodsAllSkuValueList.addAll(goodsSkuValueList);
        }

        // 若商品存在，查询该商品的所有规格值进行匹配校验
        List<GoodsSkuValueDO> dbGoodsSkuValueList = queryGoodsSkuList(goods.getCode());
        Map<Long, GoodsSkuValueDO> goodsSkuValueIdMap = new HashMap<>(dbGoodsSkuValueList.size());
        Map<String, GoodsSkuValueDO> goodsSkuValueMap = new HashMap<>(dbGoodsSkuValueList.size());
        for (GoodsSkuValueDO goodsSkuValueDO : dbGoodsSkuValueList) {
            goodsSkuValueIdMap.put(goodsSkuValueDO.getId(), goodsSkuValueDO);
            goodsSkuValueMap.put(goodsSkuValueDO.getValue(), goodsSkuValueDO);
        }

        // 存储当前规格值重复信息
        Set<String> repeatSkuValueSet = new HashSet<>(requestGoodsSkuList.size());
        for (GoodsSkuValueBO goodsSkuValue : goodsAllSkuValueList) {
            // 校验单个商品规格
            checkGoodsSkuValue(goodsSkuValue);
            CheckUtil.checkIf(repeatSkuValueSet.contains(goodsSkuValue.getValue()), "规格值不能重复【"+ goodsSkuValue.getSkuNamed() +"-"+ goodsSkuValue.getValue() +"】");
            if (Objects.nonNull(goodsSkuValue.getId())) {
                // 请求规格值带ID，根据ID匹配并进行校验
                GoodsSkuValueDO dbGoodsSkuValue = goodsSkuValueIdMap.get(goodsSkuValue.getId());
                CheckUtil.checkIf(Objects.isNull(dbGoodsSkuValue), "商品规格不存在【"+ goodsSkuValue.getId() +"】");
                goodsSkuValue.setGoodsCode(dbGoodsSkuValue.getGoodsCode());
                goodsSkuValue.setGoodsSkuCode(dbGoodsSkuValue.getGoodsSkuCode());
                goodsSkuValue.setCode(dbGoodsSkuValue.getCode());
                repeatSkuValueSet.add(goodsSkuValue.getValue());
                continue;
            }
            GoodsSkuValueDO dbGoodsSkuValue = goodsSkuValueMap.get(goodsSkuValue.getValue());
            if (Objects.nonNull(dbGoodsSkuValue)) {
                // 请求规格值与现有规格值匹配，设置其ID及相关信息
                goodsSkuValue.setId(dbGoodsSkuValue.getId());
                goodsSkuValue.setGoodsCode(dbGoodsSkuValue.getGoodsCode());
                goodsSkuValue.setGoodsSkuCode(dbGoodsSkuValue.getGoodsSkuCode());
                goodsSkuValue.setCode(dbGoodsSkuValue.getCode());
                repeatSkuValueSet.add(goodsSkuValue.getValue());
                continue;
            }
            // 请求规格值为新规格值
            goodsSkuValue.setGoodsCode(goods.getCode());
            goodsSkuValue.setGoodsSkuCode(goods.getCode());
            goodsSkuValue.setCode(CodeUtil.getGoodsSkuValueCode());
            repeatSkuValueSet.add(goodsSkuValue.getValue());
        }
        return CopyUtil.copy(goodsAllSkuValueList, GoodsSkuValueDO.class);
    }

    /**
     * 校验单个商品规格
     *
     * @param goodsSkuValue {@link GoodsSkuValueBO}
     */
    private void checkGoodsSkuValue(GoodsSkuValueBO goodsSkuValue) {
        CheckUtil.checkLength(goodsSkuValue.getValue(), 32, "规格值");
    }

    /**
     * 根据商品编码查询商品规格值列表
     *
     * @param goodsCode 商品编码
     * @return {@link List<GoodsSkuValueDO>}
     */
    private List<GoodsSkuValueDO> queryGoodsSkuList(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)) {
            return Collections.emptyList();
        }
        GoodsSkuValueDO query = new GoodsSkuValueDO();
        query.setGoodsCode(goodsCode);
        query.setIsDeleted(0L);
        return list(new LambdaQueryWrapper<>(query));
    }
}
