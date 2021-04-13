package org.open.boot.dao.goods;

import org.open.boot.dao.goods.business.GoodsBO;
import org.open.boot.dao.goods.business.GoodsSkuBO;
import org.open.boot.dao.goods.entity.GoodsSkuDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 商品规格信息表服务类
 *
 * @author barnak
 */
public interface GoodsSkuManager extends IService<GoodsSkuDO> {

    /**
     * 获取规格列表
     * <p>
     *     校验规格信息是否正确，并向规格补充code等必要参数
     * </p>
     *
     * @param save {@link GoodsBO}
     * @return {@link List<GoodsSkuDO>}
     */
    List<GoodsSkuDO> getGoodsSkuList(GoodsBO save);

    /**
     * 校验单个商品的规格列表
     * <p>
     *     仅对商品规格信息进行校验，不设置任何值
     * </p>
     *
     * @param goodsSkuList {@link List<GoodsSkuBO>}
     */
    void onlyCheckGoodsSku(List<GoodsSkuBO> goodsSkuList);
}
