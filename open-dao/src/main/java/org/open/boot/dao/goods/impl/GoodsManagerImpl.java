package org.open.boot.dao.goods.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.goods.GoodsSkuDetailManager;
import org.open.boot.dao.goods.GoodsManager;
import org.open.boot.dao.goods.GoodsSkuManager;
import org.open.boot.dao.goods.GoodsSkuValueManager;
import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.entity.GoodsDO;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;
import org.open.boot.dao.goods.entity.GoodsSkuValueDO;
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
    private GoodsSkuValueManager goodsSkuValueManager;
    @Resource
    private GoodsSkuDetailManager goodsSkuDetailManager;

    @Override
    public GoodsBO saveGoodsInfo(GoodsBO save) {
        // 参数校验
        checkGoodsParam(save);
        // 参数补全
        save.setCode(IdUtil.simpleUUID());
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
     * @param save {@link GoodsDO}
     */
    private void checkGoodsParam(GoodsDO save) {

    }
}
