package org.open.boot.dao.goods;

import org.open.boot.dao.goods.business.GoodsBO;
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
     *
     * @param save {@link GoodsBO}
     * @return {@link List<GoodsSkuDO>}
     */
    List<GoodsSkuDO> getGoodsSkuList(GoodsBO save);
}
