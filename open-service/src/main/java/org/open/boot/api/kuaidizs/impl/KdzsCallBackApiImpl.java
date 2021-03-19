package org.open.boot.api.kuaidizs.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.logging.Logger;
import org.open.boot.api.kuaidizs.KdzsCallBackApi;
import org.open.boot.api.kuaidizs.dto.*;
import org.open.boot.api.kuaidizs.enums.KdzsMethodEnum;
import org.open.boot.api.kuaidizs.util.KdzsUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 快递助手：回调接口实现
 *
 * @author barnak
 */
@Service
public class KdzsCallBackApiImpl implements KdzsCallBackApi {

    private static final Logger logger = Logger.getLogger(KdzsCallBackApiImpl.class);

    @Override
    public KdzsResponseDTO<Object> callBack(KdzsRequestDTO request) {
        // 保存任务信息
        try {
            logger.info("快递助手接口操作回调【"+ JSON.toJSONString(request) +"】");
            if (!KdzsUtils.checkSign(request)) {
                // 签名校验失败，数据与签名不一致
                return KdzsUtils.fail("签名验证失败");
            }
            String method = request.getMethod();
            if ( Objects.equals(KdzsMethodEnum.CALLBACK_TRADE_SEND.getValue(), method) ) {
                KdzsMallTradeSendDTO mallTradeSend = JSONObject.parseObject(request.getAppParam(), KdzsMallTradeSendDTO.class);
                return tradeSend(mallTradeSend);
            }
            if ( Objects.equals(KdzsMethodEnum.CALLBACK_TRADE_UPDATE_MEMO.getValue(), method) ) {
                KdzsTradeMessageDTO tradeMessage = JSONObject.parseObject(request.getAppParam(), KdzsTradeMessageDTO.class);
                return updateMemo(tradeMessage);
            }
            if ( Objects.equals(KdzsMethodEnum.CALLBACK_USER_LOGIN.getValue(), method) ) {
                KdzsUserLoginDTO userLogin = JSONObject.parseObject(request.getAppParam(), KdzsUserLoginDTO.class);
                return userLogin(userLogin);
            }
            if ( Objects.equals(KdzsMethodEnum.CALLBACK_USER_PUSH.getValue(), method) ) {
                KdzsUserPushDTO userPush = JSONObject.parseObject(request.getAppParam(), KdzsUserPushDTO.class);
                return userPush(userPush);
            }
            logger.info("快递助手接口操作回调未找到方法【"+ method +"】");
            return KdzsUtils.fail("方法调用有误");
        } catch (Exception e) {
            // 设置任务处理失败
            return KdzsUtils.fail(e.getMessage());
        }
    }

    @Override
    public KdzsResponseDTO<Object> tradeSend(KdzsMallTradeSendDTO mallTradeSend) {
        logger.info("同步回调发货【"+ JSON.toJSONString(mallTradeSend) +"】");
        if (null == mallTradeSend) {
            return KdzsUtils.fail("同步发货失败");
        }
        try {
            KdzsResponseDTO<Object> responseDto = KdzsUtils.success("同步发货成功");
            logger.info("同步回调发货成功【"+ JSON.toJSONString(responseDto) +"】");
            return responseDto;
        } catch (Exception e) {
            KdzsResponseDTO<Object> responseDto = KdzsUtils.fail(e.getMessage());
            logger.info("同步回调发货失败【"+ JSON.toJSONString(responseDto) +"】");
            return responseDto;
        }
    }

    @Override
    public KdzsResponseDTO<Object> updateMemo(KdzsTradeMessageDTO tradeMessage) {
        logger.info("同步留言修改【"+ JSON.toJSONString(tradeMessage) +"】");
        if (null == tradeMessage) {
            return KdzsUtils.fail("修改备注失败");
        }
        try {
            KdzsResponseDTO<Object> responseDto = KdzsUtils.success("修改备注成功");
            logger.info("同步留言修改成功【"+ JSON.toJSONString(responseDto) +"】");
            return responseDto;
        } catch (Exception e) {
            KdzsResponseDTO<Object> responseDto = KdzsUtils.fail(e.getMessage());
            logger.info("同步留言修改失败【"+ JSON.toJSONString(responseDto) +"】");
            return responseDto;
        }
    }

    @Override
    public KdzsResponseDTO<Object> userPush(KdzsUserPushDTO userPush) {
        logger.info("回调mallUserId推送【"+ JSON.toJSONString(userPush) +"】");
        if (null == userPush) {
            return KdzsUtils.fail("该店铺不存在");
        }
        // TODO 校验及处理方法
        return KdzsUtils.success("现在登录的是" + userPush.getMallUserId() + "号店铺");
    }

    @Override
    public KdzsResponseDTO<Object> userLogin(KdzsUserLoginDTO userLogin) {
        logger.info("回调登录【"+ JSON.toJSONString(userLogin) +"】");
        if (null == userLogin) {
            return KdzsUtils.fail("店铺无效或token失效");
        }
        // TODO 校验及处理方法
        return KdzsUtils.success("该店铺有效");
    }
}
