package org.open.boot.api.kuaidizs.util;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.open.boot.api.kuaidizs.config.KdzsConfig;
import org.open.boot.api.kuaidizs.dto.KdzsMallTradeDTO;
import org.open.boot.api.kuaidizs.dto.KdzsRequestDTO;

import java.util.Arrays;

/**
 * @author barnak
 */
public class KdzsUtils {

    public static KdzsRequestDTO buildRequest(String appParam, String method) {
        KdzsRequestDTO request = new KdzsRequestDTO();
        request.setAppKey(KdzsConfig.config().getAppKey());
        request.setMethod(method);
        request.setTimestamp(System.currentTimeMillis());
        request.setV(KdzsConfig.config().getVersion());
        request.setAppParam(JSON.toJSONString(appParam));
        request.setSignMethod(KdzsConfig.config().getSignMethod());
        request.setSign(signRequestCommon(JSONObject.parseObject(request.getAppParam()), KdzsConfig.config().getAppSecret()));
        return request;
    }


    private static String signRequestCommon(JSONObject params, String appSecret) {
        StringBuilder sb = new StringBuilder(appSecret);
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        int len = keys.length;
        for (int i = 0; i < len; ++i) {
            String key = keys[i];
            String value = params.getString(key);
            if (StringUtils.isEmpty(value) || "sign".equals(key)) {
                continue;
            }
            if (i != 0) {
                sb.append("&");
            }
            sb.append(key).append("=").append(value);
        }
        sb.append(appSecret);
        return SecureUtil.md5(sb.toString()).toUpperCase();
    }

}
