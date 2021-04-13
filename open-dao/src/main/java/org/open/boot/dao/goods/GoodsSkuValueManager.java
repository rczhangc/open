package org.open.boot.dao.goods;

import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.entity.GoodsSkuValueDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 商品规格值信息表服务类
 *
 * @author barnak
 */
public interface GoodsSkuValueManager extends IService<GoodsSkuValueDO> {

    /**
     * 获取商品所有规格值列表
     *
     * @param save {@link GoodsBO}
     * @return {@link List<GoodsSkuValueDO>}
     */
    List<GoodsSkuValueDO> getGoodsSkuValueList(GoodsBO save);
}
