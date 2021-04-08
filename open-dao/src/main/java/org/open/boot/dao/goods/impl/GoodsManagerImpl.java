package org.open.boot.dao.goods.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.goods.GoodsSkuDetailManager;
import org.open.boot.dao.goods.GoodsManager;
import org.open.boot.dao.goods.GoodsSkuManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.entity.GoodsDO;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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
    private GoodsSkuDetailManager goodsSkuDetailManager;

    @Override
    public GoodsBO save(GoodsBO save) {
        save.setCode(IdUtil.simpleUUID());
        save.setId(1L);
        // 保存主商品信息
        super.save(save);
        List<GoodsSkuDO> goodsSkuList = goodsSkuManager.getGoodsSkuList(save);
        List<GoodsSkuDetailDO> goodsDetailList = goodsSkuDetailManager.getGoodsDetailList(save);
        goodsSkuManager.saveBatch(goodsSkuList);
        goodsSkuDetailManager.saveBatch(goodsDetailList);
        return save;
    }
}
