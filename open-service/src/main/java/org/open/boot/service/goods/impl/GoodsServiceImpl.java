package org.open.boot.service.goods.impl;

import org.open.boot.dao.goods.GoodsManager;
import org.open.boot.service.goods.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品信息表服务实现类
 *
 * @author barnak
 */
@Service
class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsManager goodsManager;

}