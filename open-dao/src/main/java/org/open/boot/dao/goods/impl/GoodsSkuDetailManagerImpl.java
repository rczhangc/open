package org.open.boot.dao.goods.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.open.boot.dao.goods.GoodsSkuDetailManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuDetailBO;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品规格详情表服务实现类
 *
 * @author barnak
 */
@Repository
class GoodsSkuDetailManagerImpl extends ServiceImpl<GoodsSkuDetailMapper, GoodsSkuDetailDO> implements GoodsSkuDetailManager {

    @Override
    public List<GoodsSkuDetailDO> getGoodsDetailList(GoodsBO save) {
        List<GoodsSkuDetailBO> requestGoodsDetailList = save.getGoodsSkuDetailList();
        if (CollectionUtils.isEmpty(requestGoodsDetailList)) {
            throw new RuntimeException("商品规格详细信息不能为空");
        }
        List<GoodsSkuDetailDO> goodsDetailList = new ArrayList<>(requestGoodsDetailList.size());
        BeanUtil.copyProperties(requestGoodsDetailList, goodsDetailList);
        return goodsDetailList;
    }
}
