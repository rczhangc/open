package org.open.boot.api.kuaidizs;

import org.open.boot.api.kuaidizs.dto.*;

/**
 * 快递助手：回调接口
 *
 * @author barnak
 */
public interface KdzsCallBackApi {

    /**
     * 快递助手操作回调
     *
     * @param request {@link KdzsRequestDTO}
     * @return {@link KdzsRequestDTO}
     */
    KdzsResponseDTO<Object> callBack(KdzsRequestDTO request);

    /**
     * 同步发货
     * 快递助手页面操作订单发货后的同步回调方法
     * 接收需要发货的订单实体类信息 自行处理之后 可修改isSuccess参数 也可自定义
     *
     * @param mallTradeSend {@link KdzsMallTradeSendDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> tradeSend(KdzsMallTradeSendDTO mallTradeSend);

    /**
     * 订单备注回传
     * 快递助手操作订单备注修改后的回调方法
     * 接收需要留言备注回传的订单实体类信息 自行处理之后 可修改isSuccess参数 也可自定义
     *
     * @param tradeMessage {@link KdzsTradeMessageDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> updateMemo(KdzsTradeMessageDTO tradeMessage);

    /**
     * 店铺信息推送
     * 此情况是多店铺模式 店铺第一次登录时需要回调该接口 推送mallUserId字段
     * 接收店铺信息 自定义校验是否有效
     *
     * @param userPush {@link KdzsUserPushDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> userPush(KdzsUserPushDTO userPush);

    /**
     * 店铺登录
     * 此情况是多店铺模式 店铺每次登录需回调此接口
     * 接收店铺token 自定义校验是否有效
     *
     * @param userLogin {@link KdzsUserLoginDTO}
     * @return {@link KdzsResponseDTO}
     */
    KdzsResponseDTO<Object> userLogin(KdzsUserLoginDTO userLogin);
}
