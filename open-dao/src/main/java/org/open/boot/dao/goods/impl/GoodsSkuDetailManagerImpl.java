package org.open.boot.dao.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.constants.Constants;
import org.open.boot.dao.goods.GoodsSkuDetailManager;
import org.open.boot.dao.goods.GoodsSkuManager;
import org.open.boot.dao.goods.business.*;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;
import org.open.boot.util.CheckUtil;
import org.open.boot.util.CodeUtil;
import org.open.boot.util.CopyUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 商品规格详情表服务实现类
 *
 * @author barnak
 */
@Repository
class GoodsSkuDetailManagerImpl extends ServiceImpl<GoodsSkuDetailMapper, GoodsSkuDetailDO> implements GoodsSkuDetailManager {

    @Resource
    private GoodsSkuManager goodsSkuManager;

    @Override
    public List<GoodsSkuDetailDO> getGoodsDetailList(GoodsBO goods) {
        List<GoodsSkuDetailBO> requestGoodsSkuDetailList = goods.getGoodsSkuDetailList();
        if (CollectionUtils.isEmpty(requestGoodsSkuDetailList)) {
            throw new RuntimeException("商品规格详情信息不能为空");
        }
        // 校验规格详情信息
        checkGoodsSkuDetailList(requestGoodsSkuDetailList, goods.getGoodsSkuList());

        GoodsSkuDetailDO goodsSkuDetailQuery = new GoodsSkuDetailDO();
        goodsSkuDetailQuery.setGoodsCode(goods.getCode());
        goodsSkuDetailQuery.setIsDeleted(0L);
        List<GoodsSkuDetailDO> goodsSkuDetailList = list(new LambdaQueryWrapper<>(goodsSkuDetailQuery));

        Map<String, GoodsSkuDetailDO> skuDetailValueMakeMap = new HashMap<>(goodsSkuDetailList.size());
        for (GoodsSkuDetailDO goodsSkuDetailDO : goodsSkuDetailList) {
            String skuMakeValueKey = getSkuMakeValueKey(goodsSkuDetailDO.getSkuMakeValueList());
            skuDetailValueMakeMap.put(skuMakeValueKey, goodsSkuDetailDO);
        }
        for (GoodsSkuDetailBO requestGoodsSkuDetail : requestGoodsSkuDetailList) {
            String skuMakeValueKey = getSkuMakeValueKey(requestGoodsSkuDetail.getSkuMakeValueList());
            GoodsSkuDetailDO goodsSkuDetailDO = skuDetailValueMakeMap.get(skuMakeValueKey);
            if (Objects.nonNull(goodsSkuDetailDO)) {
                requestGoodsSkuDetail.setGoodsCode(goodsSkuDetailDO.getGoodsCode());
                requestGoodsSkuDetail.setCode(goodsSkuDetailDO.getCode());
                // 设置规格编码组合
                requestGoodsSkuDetail.setSkuMakeValueCode(getSkuMakeValueCodeKey(requestGoodsSkuDetail.getSkuMakeValueList()));
                requestGoodsSkuDetail.setStockLock(goodsSkuDetailDO.getStockLock());
                requestGoodsSkuDetail.setStockSurplus(goodsSkuDetailDO.getStockSurplus());
                continue;
            }
            requestGoodsSkuDetail.setGoodsCode(goods.getCode());
            requestGoodsSkuDetail.setCode(CodeUtil.getGoodsSkuDetailCode());
            // 设置规格编码组合
            requestGoodsSkuDetail.setSkuMakeValueCode(getSkuMakeValueCodeKey(requestGoodsSkuDetail.getSkuMakeValueList()));
            requestGoodsSkuDetail.setStockLock(0);
            requestGoodsSkuDetail.setStockSurplus(0);
        }
        return CopyUtil.copy(requestGoodsSkuDetailList, GoodsSkuDetailDO.class);
    }

    @Override
    public List<GoodsSkuDetailBO> buildGoodsDetailList(List<GoodsSkuBO> goodsSkuList) {
        // 校验商品规格信息
        goodsSkuManager.onlyCheckGoodsSku(goodsSkuList);
        // 返回根据商品规格构建的商品规格详情列表
        return buildGoodsSkuDetailList(goodsSkuList);
    }

    /**
     * 校验商品规格详情信息
     * <p>
     *     将请求传入的商品规格信息转换为规格详情与请求直接传入的规格详情信息进行对比校验
     * </p>
     * @param requestGoodsSkuDetailList 请求传入的规格详情信息 {@link List<GoodsSkuDetailBO>}
     * @param goodsSkuList 请求传入的商品规格信息
     */
    private void checkGoodsSkuDetailList(List<GoodsSkuDetailBO> requestGoodsSkuDetailList, List<GoodsSkuBO> goodsSkuList) {
        // 根据请求商品规格构建商品规格详情信息
        List<GoodsSkuDetailBO> buildGoodsSkuDetailList = buildGoodsSkuDetailList(goodsSkuList);
        if (requestGoodsSkuDetailList.size() != buildGoodsSkuDetailList.size()) {
            throw new RuntimeException("商品规格详情组合错误【请求规格数："+ requestGoodsSkuDetailList.size() +"，目标规格数："+ buildGoodsSkuDetailList.size() +"】");
        }
        // Key为商品规格值组合结果
        Map<String, GoodsSkuDetailBO> buildGoodsSkuDetailMap = buildGoodsSkuDetailList.stream()
                .collect(Collectors.toMap(o -> getSkuMakeValueKey(o.getSkuMakeValueList()), Function.identity()));
        // 用来统计请求规格出现重复次数
        Map<String, Integer> requestGoodsSkuDetailRepeatMap = new HashMap<>(requestGoodsSkuDetailList.size());
        for (GoodsSkuDetailBO requestGoodsSkuDetail : requestGoodsSkuDetailList) {
            // 校验单个商品规格详情
            checkGoodsSkuDetail(requestGoodsSkuDetail);
            // 请求规格详情中的规格值组合Key
            String requestMakeSkuValueKey = getSkuMakeValueKey(requestGoodsSkuDetail.getSkuMakeValueList());
            GoodsSkuDetailBO buildGoodsSkuDetail = buildGoodsSkuDetailMap.get(requestMakeSkuValueKey);
            // 获取当前商品规格详情重复次数
            Integer skuDetailRepeatNum = requestGoodsSkuDetailRepeatMap.getOrDefault(requestMakeSkuValueKey, 0);
            if (skuDetailRepeatNum > 0 ) {
                throw new RuntimeException("商品详情规格值组合重复【"+ requestMakeSkuValueKey +"】");
            }
            if (null == buildGoodsSkuDetail) {
                throw new RuntimeException("商品详情规格值组合错误【"+ requestMakeSkuValueKey +"】");
            }
            // 已校验过的从构建列表中移除
            buildGoodsSkuDetailMap.remove(requestMakeSkuValueKey);
            // 请求规格值组合重复次数增加
            requestGoodsSkuDetailRepeatMap.put(requestMakeSkuValueKey, skuDetailRepeatNum + 1);
        }
    }

    /**
     * 校验单个规格详情参数
     *
     * @param requestGoodsSkuDetail {@link GoodsSkuDetailBO}
     */
    private void checkGoodsSkuDetail(GoodsSkuDetailBO requestGoodsSkuDetail) {
        CheckUtil.checkDecimalPlacesLength(requestGoodsSkuDetail.getPrice(),2, "规格实际价格");
        CheckUtil.checkIntegerBitLength(requestGoodsSkuDetail.getPrice(), 7, "规格实际价格");
        CheckUtil.checkDecimalPlacesLength(requestGoodsSkuDetail.getPriceOriginal(),2, "规格原价");
        CheckUtil.checkIntegerBitLength(requestGoodsSkuDetail.getPriceOriginal(), 7, "规格原价");
        CheckUtil.checkDecimalPlacesLength(requestGoodsSkuDetail.getPriceCost(),2, "规格成本价");
        CheckUtil.checkIntegerBitLength(requestGoodsSkuDetail.getPriceCost(), 7, "规格成本价");
        CheckUtil.checkSize(requestGoodsSkuDetail.getStockTotal(), 1, 999999999, "规格总库存");
    }

    /**
     * 根据商品规格信息构建商品详情信息
     * <p>
     *     多规格商品详情信息是由商品详情值进行笛卡尔积后的结果
     *     该方法仅进行计算，不进行校验，不设置字段值，使用前需要先进行校验
     * </p>
     *
     * @param goodsSkuList {@link List<GoodsSkuBO>}
     * @return {@link List<GoodsSkuDetailBO>}
     */
    private List<GoodsSkuDetailBO> buildGoodsSkuDetailList(List<GoodsSkuBO> goodsSkuList) {
        // 存储所有规格值
        List<List<GoodsSkuValueBO>> goodsSkuAllValueList = new ArrayList<>();
        for (GoodsSkuBO goodsSku : goodsSkuList) {
            List<GoodsSkuValueBO> goodsSkuValueList = goodsSku.getGoodsSkuValueList();
            // 设置规格值所属的规格名称
            goodsSkuValueList.forEach(o -> o.setSkuNamed(goodsSku.getNamed()));
            goodsSkuAllValueList.add(goodsSkuValueList);
        }
        // 存储规格值组合结果
        List<List<GoodsSkuValueBO>> goodsSkuMakeValueList = new ArrayList<>();
        for (List<GoodsSkuValueBO> goodsSkuValueList : goodsSkuAllValueList) {
            goodsSkuMakeValueList = buildSkuValueDescartes(goodsSkuMakeValueList, goodsSkuValueList);
        }
        return convertGoodsSkuDetailList(goodsSkuMakeValueList);
    }

    /**
     * 计算商品规格组合
     * <p>
     *     规格使用笛卡尔积的方式组合，此处将规格一组组进行计算组合
     * </p>
     *
     * @param oldGoodsSkuMakeValueList 旧规格组合结果列表 {@link List<GoodsSkuValueBO>}
     * @param goodsSkuValueList 需要进行组合的规格列表 {@link List<GoodsSkuValueBO>}
     * @return 新规格组合列表 {@link List<GoodsSkuValueBO>}
     */
    private List<List<GoodsSkuValueBO>> buildSkuValueDescartes(List<List<GoodsSkuValueBO>> oldGoodsSkuMakeValueList,
                                                               List<GoodsSkuValueBO> goodsSkuValueList) {
        // 新计算结果存储列表
        List<List<GoodsSkuValueBO>> newGoodsSkuMakeValueList = new ArrayList<>();
        if (CollectionUtils.isEmpty(oldGoodsSkuMakeValueList)) {
            // 旧结果列表为空说明是首次调用该方法，将规格值放入结果中
            for (GoodsSkuValueBO value : goodsSkuValueList) {
                newGoodsSkuMakeValueList.add(Collections.singletonList(value));
            }
            return newGoodsSkuMakeValueList;
        }
        // 计算新的结果
        for (GoodsSkuValueBO goodsSkuValue : goodsSkuValueList) {
            for (List<GoodsSkuValueBO> oldGoodsSkuValueList : oldGoodsSkuMakeValueList) {
                List<GoodsSkuValueBO> newGoodsSkuValueList = CopyUtil.copy(oldGoodsSkuValueList, GoodsSkuValueBO.class);
                newGoodsSkuValueList.add(goodsSkuValue);
                newGoodsSkuMakeValueList.add(newGoodsSkuValueList);
            }
        }
        return newGoodsSkuMakeValueList;
    }

    /**
     * 将规格值组合转换为商品规格详情列表
     *
     * @param goodsSkuMakeValueList 规格值组合列表 {@link List<GoodsSkuValueBO>}
     * @return {@link List<GoodsSkuDetailBO>}
     */
    private List<GoodsSkuDetailBO> convertGoodsSkuDetailList(List<List<GoodsSkuValueBO>> goodsSkuMakeValueList) {
        List<GoodsSkuDetailBO> goodsSkuDetailList = new ArrayList<>();
        for (List<GoodsSkuValueBO> goodsSkuValueList : goodsSkuMakeValueList) {
            GoodsSkuDetailBO skuDetail = new GoodsSkuDetailBO();
            // 构建商品规格详情中的规格值列表
            List<GoodsSkuMakeValueBO> skuMakeValueList = new ArrayList<>();
            for (GoodsSkuValueBO goodsSkuValueBO : goodsSkuValueList) {
                GoodsSkuMakeValueBO goodsSkuMakeValueBO = new GoodsSkuMakeValueBO();
                goodsSkuMakeValueBO.setSkuValue(goodsSkuValueBO.getValue());
                goodsSkuMakeValueBO.setSkuCode(goodsSkuValueBO.getGoodsSkuCode());
                goodsSkuMakeValueBO.setSkuName(goodsSkuValueBO.getSkuNamed());
            }
            skuDetail.setSkuMakeValueList(skuMakeValueList);
            goodsSkuDetailList.add(skuDetail);
        }
        return goodsSkuDetailList;
    }

    /**
     * 获取规格值组合字符串
     * <p>
     *     规格值按照字符串自然排序后使用下划线 {@link Constants.Symbol#UNDERLINE} 进行组合
     *     用于规格编码未生成是的匹配校验
     * </p>
     *
     * @param skuMakeValueList {@link List<GoodsSkuMakeValueBO>}
     * @return 规格值组合字符串
     */
    private String getSkuMakeValueKey(List<GoodsSkuMakeValueBO> skuMakeValueList) {
        return skuMakeValueList.stream().map(GoodsSkuMakeValueBO::getSkuValue).sorted()
                .collect(Collectors.joining(Constants.Symbol.UNDERLINE));
    }

    /**
     * 获取规格值编码组合字符串
     * <p>
     *     规格值编码按照字符串自然排序后使用下划线 {@link Constants.Symbol#UNDERLINE} 进行组合
     * </p>
     *
     * @param skuMakeValueList {@link List<GoodsSkuMakeValueBO>}
     * @return 规格值编码组合字符串
     */
    private String getSkuMakeValueCodeKey(List<GoodsSkuMakeValueBO> skuMakeValueList) {
        return skuMakeValueList.stream().map(GoodsSkuMakeValueBO::getSkuValueCode).sorted()
                .collect(Collectors.joining(Constants.Symbol.UNDERLINE));
    }
}
