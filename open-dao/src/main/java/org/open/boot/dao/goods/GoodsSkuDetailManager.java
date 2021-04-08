package org.open.boot.dao.goods;

import org.open.boot.dao.goods.business.GoodsBO;
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
}
