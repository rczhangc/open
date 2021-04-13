package org.open.boot.dao.goods.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.open.boot.constants.Constants;
import org.open.boot.dao.goods.GoodsSkuDetailManager;
import org.open.boot.dao.goods.GoodsManager;
import org.open.boot.dao.goods.GoodsSkuManager;
import org.open.boot.dao.goods.GoodsSkuValueManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuMakeValueBO;
import org.open.boot.dao.goods.entity.GoodsDO;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;
import org.open.boot.dao.goods.entity.GoodsSkuValueDO;
import org.open.boot.util.CheckUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 商品信息表服务实现类
 *
 * @author barnak
 */
@Repository
class GoodsManagerImpl extends ServiceImpl<GoodsMapper, GoodsDO> implements GoodsManager {

    @Resource
    private GoodsSkuManager goodsSkuManager;
    @Resource
    private GoodsSkuValueManager goodsSkuValueManager;
    @Resource
    private GoodsSkuDetailManager goodsSkuDetailManager;

    @Override
    public GoodsBO saveGoodsInfo(GoodsBO save) {
        // 参数校验
        checkGoodsParam(save);
        // 参数补全
        save.setCode(IdUtil.simpleUUID());
        save.setStatus(10);
        // 获取关联参数
        List<GoodsSkuDO> goodsSkuList = goodsSkuManager.getGoodsSkuList(save);
        List<GoodsSkuValueDO> goodsSkuValueList = goodsSkuValueManager.getGoodsSkuValueList(save);
        List<GoodsSkuDetailDO> goodsDetailList = goodsSkuDetailManager.getGoodsDetailList(save);
        // 保存信息
        save(save);
        goodsSkuManager.saveBatch(goodsSkuList);
        goodsSkuValueManager.saveBatch(goodsSkuValueList);
        goodsSkuDetailManager.saveBatch(goodsDetailList);
        return save;
    }

    @Override
    public GoodsBO updateGoodsInfo(GoodsBO update) {
        CheckUtil.checkIf(Objects.isNull(update.getId()), "商品ID不能为空");
        // 参数校验
        checkGoodsParam(update);
        update.setStatus(10);
        GoodsDO goods = getById(update.getId());
        CheckUtil.checkIf(Objects.isNull(goods), "商品信息不存在");

        GoodsSkuDO goodsSkuQuery = new GoodsSkuDO();
        goodsSkuQuery.setGoodsCode(goods.getCode());
        goodsSkuQuery.setIsDeleted(0L);
        List<GoodsSkuDO> goodsSkuList = goodsSkuManager.list(new LambdaQueryWrapper<>(goodsSkuQuery));

        GoodsSkuValueDO goodsSkuValueQuery = new GoodsSkuValueDO();
        goodsSkuValueQuery.setGoodsCode(goods.getCode());
        goodsSkuValueQuery.setIsDeleted(0L);
        List<GoodsSkuValueDO> goodsSkuValueList = goodsSkuValueManager.list(new LambdaQueryWrapper<>(goodsSkuValueQuery));

        GoodsSkuDetailDO goodsSkuDetailQuery = new GoodsSkuDetailDO();
        goodsSkuDetailQuery.setGoodsCode(goods.getCode());
        goodsSkuDetailQuery.setIsDeleted(0L);
        List<GoodsSkuDetailDO> goodsSkuDetailList = goodsSkuDetailManager.list(new LambdaQueryWrapper<>(goodsSkuDetailQuery));

        // 获取关联参数
        List<GoodsSkuDO> updateGoodsSkuList = goodsSkuManager.getGoodsSkuList(update);
        List<GoodsSkuValueDO> updateGoodsSkuValueList = goodsSkuValueManager.getGoodsSkuValueList(update);
        List<GoodsSkuDetailDO> updateGoodsSkuDetailList = goodsSkuDetailManager.getGoodsDetailList(update);

        Map<Long, GoodsSkuDO> goodsSkuIdMap = new HashMap<>();
        Map<String, GoodsSkuDO> goodsSkuNamedMap = new HashMap<>();
        for (GoodsSkuDO goodsSkuDO : goodsSkuList) {
            goodsSkuIdMap.put(goodsSkuDO.getId(), goodsSkuDO);
            goodsSkuNamedMap.put(goodsSkuDO.getNamed(), goodsSkuDO);
        }

        List<GoodsSkuDO> updateSkuList = new ArrayList<>();
        List<GoodsSkuDO> insertSkuList = new ArrayList<>();
        for (GoodsSkuDO goodsSku : updateGoodsSkuList) {
            if (Objects.nonNull(goodsSku.getId())) {
                GoodsSkuDO goodsSkuDO = goodsSkuIdMap.get(goodsSku.getId());
                CheckUtil.checkIf(Objects.isNull(goodsSkuDO), "商品规格不存在【"+ goodsSku.getId() +"】");
                updateSkuList.add(goodsSku);
                continue;
            }
            if (StringUtils.isNotBlank(goodsSku.getNamed())) {
                GoodsSkuDO goodsSkuDO = goodsSkuNamedMap.get(goodsSku.getNamed());
                CheckUtil.checkIf(Objects.isNull(goodsSkuDO), "商品规格不存在【"+ goodsSku.getId() +"】");
                goodsSku.setId(goodsSkuDO.getId());
                updateSkuList.add(goodsSku);
                continue;
            }
            insertSkuList.add(goodsSku);
        }

        Map<Long, GoodsSkuValueDO> goodsSkuValueIdMap = new HashMap<>();
        Map<String, GoodsSkuValueDO> goodsSkuValueMap = new HashMap<>();
        for (GoodsSkuValueDO goodsSkuValueDO : goodsSkuValueList) {
            goodsSkuValueIdMap.put(goodsSkuValueDO.getId(), goodsSkuValueDO);
            goodsSkuValueMap.put(goodsSkuValueDO.getValue(), goodsSkuValueDO);
        }

        List<GoodsSkuValueDO> updateSkuValueList = new ArrayList<>();
        List<GoodsSkuValueDO> insertSkuValueList = new ArrayList<>();
        for (GoodsSkuValueDO goodsSkuValueDO : updateGoodsSkuValueList) {
            if (Objects.nonNull(goodsSkuValueDO.getId())) {
                GoodsSkuValueDO goodsSkuValue = goodsSkuValueIdMap.get(goodsSkuValueDO.getId());
                CheckUtil.checkIf(Objects.isNull(goodsSkuValue), "商品规格不存在【"+ goodsSkuValueDO.getId() +"】");
                updateSkuValueList.add(goodsSkuValueDO);
                continue;
            }
            if (StringUtils.isNotBlank(goodsSkuValueDO.getValue())) {
                GoodsSkuValueDO goodsSkuValue = goodsSkuValueMap.get(goodsSkuValueDO.getValue());
                CheckUtil.checkIf(Objects.isNull(goodsSkuValue), "商品规格不存在【"+ goodsSkuValueDO.getId() +"】");
                goodsSkuValueDO.setId(goodsSkuValue.getId());
                updateSkuValueList.add(goodsSkuValueDO);
                continue;
            }
            insertSkuValueList.add(goodsSkuValueDO);
        }

        Map<String, GoodsSkuDetailDO> skuDetailValueMakeMap = new HashMap<>();
        Map<Long, GoodsSkuDetailDO>  skuDetailIdMap = new HashMap<>();
        for (GoodsSkuDetailDO goodsSkuDetailDO :goodsSkuDetailList) {
            String skuMakeValueKey = getSkuMakeValueKey(goodsSkuDetailDO.getSkuMakeValueList());
            skuDetailValueMakeMap.put(skuMakeValueKey, goodsSkuDetailDO);
            skuDetailIdMap.put(goodsSkuDetailDO.getId(), goodsSkuDetailDO);
        }

        return null;
    }

    /**
     * 获取规格值组合字符串
     * <p>
     *     规格值按照字符串自然排序后使用下划线 {@link Constants.Symbol#UNDERLINE} 进行组合
     *     用于规格编码未生成是的匹配校验
     * </p>
     *
     * @param skuMakeValueList {@link List< GoodsSkuMakeValueBO >}
     * @return 规格值组合字符串
     */
    private String getSkuMakeValueKey(List<GoodsSkuMakeValueBO> skuMakeValueList) {
        return skuMakeValueList.stream().map(GoodsSkuMakeValueBO::getSkuValue).sorted()
                .collect(Collectors.joining(Constants.Symbol.UNDERLINE));
    }

    @Override
    public boolean saveGoodsInfo(GoodsDO entity) {
        entity.setCode(IdUtil.simpleUUID());
        return super.save(entity);
    }

    @Override
    public GoodsDO getById(Long id) {
        return super.getById(id);
    }

    /**
     * 校验商品参数
     *
     * @param goods {@link GoodsDO}
     */
    private void checkGoodsParam(GoodsDO goods) {
        CheckUtil.checkLength(goods.getTitle(), 32, "商品标题");
        CheckUtil.checkLength(goods.getNamed(), 32, "商品名称");
        if (StringUtils.isNotBlank(goods.getDescription())) {
            CheckUtil.checkLength(goods.getDescription(), 32, "商品描述");
        }
        CheckUtil.checkIf(CollectionUtils.isEmpty(goods.getImgCoverUrlList()), "商品封面图不能为空");
        CheckUtil.checkIf(CollectionUtils.isEmpty(goods.getImgDetailsUrlList()), "商品详情图不能为空");
        CheckUtil.checkDecimalPlacesLength(goods.getPrice(),2, "商品实际价格");
        CheckUtil.checkIntegerBitLength(goods.getPrice(), 7, "商品实际价格");
        CheckUtil.checkDecimalPlacesLength(goods.getPriceOriginal(),2, "商品原价");
        CheckUtil.checkIntegerBitLength(goods.getPriceOriginal(), 7, "商品原价");
        CheckUtil.checkDecimalPlacesLength(goods.getPriceCost(),2, "商品成本价");
        CheckUtil.checkIntegerBitLength(goods.getPriceCost(), 7, "商品成本价");
    }
}
