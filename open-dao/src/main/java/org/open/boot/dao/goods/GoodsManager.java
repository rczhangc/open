package org.open.boot.dao.goods;

import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.entity.GoodsDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品信息表服务类
 *
 * @author barnak
 */
public interface GoodsManager {

    /**
     * 保存商品信息
     *
     * @param save 需要保存的商品信息 {@link GoodsBO}
     * @return 保存后的商品信息 {@link GoodsBO}
     */
    GoodsBO saveGoodsInfo(GoodsBO save);

    /**
     * 修改商品信息
     *
     * @param update {@link GoodsBO}
     * @return {@link GoodsBO}
     */
    GoodsBO updateGoodsInfo(GoodsBO update);

    /**
     * 保存单个商品信息
     *
     * @param save {@link GoodsDO}
     * @return {@link GoodsDO}
     */
    boolean saveGoodsInfo(GoodsDO save);

    GoodsDO getById(Long id);
}
