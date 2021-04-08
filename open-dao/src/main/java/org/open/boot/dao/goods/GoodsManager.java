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
    GoodsBO save(GoodsBO save);
}
