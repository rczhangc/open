package org.open.boot.dao.goods;

import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuBO;
import org.open.boot.dao.goods.business.GoodsSkuDetailBO;
import org.open.boot.dao.goods.entity.GoodsSkuDetailDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 商品规格详情表服务类
 *
 * @author barnak
 */
public interface GoodsSkuDetailManager extends IService<GoodsSkuDetailDO> {

    /**
     * 获取商品详情信息
     *
     * @param save {@link GoodsBO}
     * @return {@link List<GoodsSkuDetailDO>}
     */
    List<GoodsSkuDetailDO> getGoodsDetailList(GoodsBO save);

    /**
     * 根据商品规格信息构建商品详情
     *
     * @param goodsSkuList 商品规格信息 {@link List<GoodsSkuBO>}
     * @return {@link List<GoodsSkuDetailBO>}
     */
    List<GoodsSkuDetailBO> buildGoodsDetailList(List<GoodsSkuBO> goodsSkuList);
}
