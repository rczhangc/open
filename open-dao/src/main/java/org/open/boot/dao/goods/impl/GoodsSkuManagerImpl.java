package org.open.boot.dao.goods.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.dao.goods.GoodsSkuManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuBO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        if (CollectionUtils.isEmpty(requestGoodsSkuList)) {
            throw new RuntimeException("规格信息为空");
        }
        for (GoodsSkuBO requestSku : requestGoodsSkuList) {
            checkGoodsSku(requestSku);
            requestSku.setGoodsCode(goods.getCode());
            requestSku.setCode(IdUtil.simpleUUID());
        }
        List<GoodsSkuDO> goodsSkuList = new ArrayList<>(requestGoodsSkuList.size());
        BeanUtil.copyProperties(requestGoodsSkuList, goodsSkuList);
        return goodsSkuList;
    }

    private void checkGoodsSku(GoodsSkuDO goodsSku) {

    }
}
