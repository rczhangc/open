package org.open.boot.dao.goods.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.dao.goods.GoodsSkuValueManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuBO;
import org.open.boot.dao.goods.business.GoodsSkuValueBO;
import org.open.boot.dao.goods.entity.GoodsSkuValueDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品规格值信息表服务实现类
 *
 * @author barnak
 */
@Repository
class GoodsSkuValueManagerImpl extends ServiceImpl<GoodsSkuValueMapper, GoodsSkuValueDO> implements GoodsSkuValueManager {

    @Override
    public List<GoodsSkuValueDO> getGoodsSkuValueList(GoodsBO goods) {
        List<GoodsSkuBO> goodsSkuList = goods.getGoodsSkuList();
        if (CollectionUtils.isEmpty(goodsSkuList)) {
            throw new RuntimeException("商品规格信息不存在");
        }
        for (GoodsSkuBO goodsSku : goodsSkuList) {
            List<GoodsSkuValueBO> goodsSkuValueList = goodsSku.getGoodsSkuValueList();
            if (CollectionUtils.isEmpty(goodsSkuValueList)) {
                throw new RuntimeException("商品规格值不能为空");
            }
            for (GoodsSkuValueBO goodsSkuValue : goodsSkuValueList) {
                checkGoodsSkuValue(goodsSkuValue);
                goodsSkuValue.setGoodsCode(goods.getCode());
                goodsSkuValue.setGoodsSkuCode(goodsSku.getGoodsCode());
                goodsSkuValue.setCode(IdUtil.simpleUUID());
            }
        }

        return null;
    }

    private void checkGoodsSkuValue(GoodsSkuValueBO goodsSkuValue) {

    }
}
