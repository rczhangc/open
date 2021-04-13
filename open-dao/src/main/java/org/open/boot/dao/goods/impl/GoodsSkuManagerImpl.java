package org.open.boot.dao.goods.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.open.boot.dao.goods.GoodsSkuManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuBO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;
import org.open.boot.util.CheckUtil;
import org.open.boot.util.CodeUtil;
import org.open.boot.util.CopyUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 商品规格信息表服务实现类
 *
 * @author barnak
 */
@Repository
class GoodsSkuManagerImpl extends ServiceImpl<GoodsSkuMapper, GoodsSkuDO> implements GoodsSkuManager {

    @Override
    public List<GoodsSkuDO> getGoodsSkuList(GoodsBO goods) {
        List<GoodsSkuBO> requestGoodsSkuList = goods.getGoodsSkuList();
        // 校验商品规格
        onlyCheckGoodsSku(requestGoodsSkuList);
        // 若商品编码存在，则进行查询
        List<GoodsSkuDO> goodsSkuList = queryGoodsSkuList(goods.getCode());
        Map<Long, GoodsSkuDO> goodsSkuIdMap = new HashMap<>(goodsSkuList.size());
        Map<String, GoodsSkuDO> goodsSkuNamedMap = new HashMap<>(goodsSkuList.size());
        for (GoodsSkuDO goodsSku : goodsSkuList) {
            // 使用规格ID和规格名称做匹配
            goodsSkuIdMap.put(goodsSku.getId(), goodsSku);
            goodsSkuNamedMap.put(goodsSku.getNamed(), goodsSku);
        }
        // 商品规格参数设置
        for (GoodsSkuBO requestGoodsSku : requestGoodsSkuList) {
            if (Objects.nonNull(requestGoodsSku.getId())) {
                // 请求参数中传入了规格ID，使用规格ID进行匹配
                GoodsSkuDO goodsSku = goodsSkuIdMap.get(requestGoodsSku.getId());
                CheckUtil.checkIf(Objects.isNull(goodsSku), "商品规格不存在【规格ID:" + requestGoodsSku.getId() + "】");
                requestGoodsSku.setGoodsCode(goodsSku.getGoodsCode());
                requestGoodsSku.setCode(goodsSku.getCode());
                continue;
            }
            // 规格中未传入规格ID，使用规格名称匹配（同一个商品的规格名称不会重复）
            GoodsSkuDO goodsSku = goodsSkuNamedMap.get(requestGoodsSku.getNamed());
            if (Objects.nonNull(goodsSku)) {
                requestGoodsSku.setGoodsCode(goodsSku.getGoodsCode());
                requestGoodsSku.setCode(goodsSku.getCode());
                continue;
            }
            // 新产生的规格重新生成编码
            requestGoodsSku.setGoodsCode(goods.getCode());
            requestGoodsSku.setCode(CodeUtil.getGoodsSkuCode());
        }
        return CopyUtil.copy(requestGoodsSkuList, GoodsSkuDO.class);
    }

    @Override
    public void onlyCheckGoodsSku(List<GoodsSkuBO> goodsSkuList) {
        if (CollectionUtils.isEmpty(goodsSkuList)) {
            throw new RuntimeException("规格信息为空");
        }
        Set<String> namedSet = new HashSet<>(goodsSkuList.size());
        for (GoodsSkuBO requestSku : goodsSkuList) {
            checkGoodsSku(requestSku);
            if (namedSet.contains(requestSku.getNamed())) {
                throw new RuntimeException("规格名称不能重复【"+ requestSku.getNamed() +"】");
            }
            namedSet.add(requestSku.getNamed());
        }
    }

    /**
     * 校验单个商品规格信息
     *
     * @param goodsSku {@link GoodsSkuDO}
     */
    private void checkGoodsSku(GoodsSkuDO goodsSku) {
        CheckUtil.checkLength(goodsSku.getNamed(), 32, "规格名称");
        if (StringUtils.isNotBlank(goodsSku.getDescription())) {
            CheckUtil.checkLength(goodsSku.getDescription(), 32, "规格描述");
        }
    }

    /**
     * 根据商品编码查询商品规格
     *
     * @param goodsCode 商品编码
     * @return {@link List<GoodsSkuDO>}
     */
    private List<GoodsSkuDO> queryGoodsSkuList(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)) {
            return Collections.emptyList();
        }
        GoodsSkuDO query = new GoodsSkuDO();
        query.setGoodsCode(goodsCode);
        query.setIsDeleted(0L);
        return list(new LambdaQueryWrapper<>(query));
    }
}
