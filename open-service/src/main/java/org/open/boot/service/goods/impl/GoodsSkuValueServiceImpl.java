package org.open.boot.service.goods.impl;

import org.open.boot.dao.goods.GoodsSkuValueManager;
import org.open.boot.service.goods.GoodsSkuValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品规格值信息表服务实现类
 *
 * @author barnak
 */
@Service
class GoodsSkuValueServiceImpl implements GoodsSkuValueService {

    @Resource
    private GoodsSkuValueManager goodsSkuValueManager;

}