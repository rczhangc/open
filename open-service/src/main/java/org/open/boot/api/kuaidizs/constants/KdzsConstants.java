package org.open.boot.api.kuaidizs.constants;

import org.open.boot.constants.Constants;

/**
 * 快递助手常量
 *
 * @author barnak
 */
public interface KdzsConstants extends Constants {

    /**
     * 方法返回常量
     */
    interface MethodResponse {

        /**
         * 成功标识
         */
        Integer SUCCESS = 200;
    }

    /**
     * 接口请求地址常量
     */
    interface MethodUrl {

        /**
         * 通用请求地址
         */
        String COMMON_URL = "https://apiopen.kuaidizs.cn/api/gateway";
    }

    /**
     * 订单相关常量
     */
    interface Order {

        /**
         * 订单
         */
        String TRADE = "trade";

        /**
         * 创建订单 trade.create
         */
        String METHOD_CREATE = TRADE + Symbol.EN_FULL_STOP +"create";

        /**
         * 批量同步订单 trade.batchCreate
         */
        String METHOD_BATCH_CREATE = TRADE + Symbol.EN_FULL_STOP +"batchCreate";

        /**
         * 修改订单信息 trade.update
         */
        String METHOD_UPDATE = TRADE + Symbol.EN_FULL_STOP +"update";

        /**
         * 订单发货 trade.send
         */
        String METHOD_SEND = TRADE + Symbol.EN_FULL_STOP +"send";

        /**
         * 订单退款 trade.refund
         */
        String METHOD_REFUND = TRADE + Symbol.EN_FULL_STOP +"refund";

        /**
         * 订单删除 trade.batchDelete
         */
        String METHOD_BATCH_DELETED = TRADE + Symbol.EN_FULL_STOP +"batchDelete";
    }
}
