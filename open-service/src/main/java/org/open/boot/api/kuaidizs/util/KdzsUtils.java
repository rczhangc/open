package org.open.boot.api.kuaidizs.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang.StringUtils;
import org.open.boot.api.kuaidizs.config.KdzsConfig;
import org.open.boot.api.kuaidizs.constants.KdzsConstants;
import org.open.boot.api.kuaidizs.dto.KdzsObjectDTO;
import org.open.boot.api.kuaidizs.dto.KdzsRequestDTO;
import org.open.boot.api.kuaidizs.dto.KdzsResponseDTO;
import org.open.boot.api.kuaidizs.enums.KdzsMethodEnum;
import org.open.boot.api.kuaidizs.exception.KdzsException;

import java.util.Arrays;
import java.util.Map;

/**
 * 快递助手工具
 *
 * @author barnak
 */
public class KdzsUtils {

    /**
     * 通用请求
     *
     * @param appParam 请求参数 {@link KdzsObjectDTO}
     * @return {@link KdzsResponseDTO}
     */
    public static KdzsResponseDTO<Object> doRequest(KdzsObjectDTO appParam, KdzsMethodEnum kdzsMethod) {
        return doRequest(JSON.toJSONString(appParam), kdzsMethod, new TypeReference<KdzsResponseDTO<Object>>(){});
    }

    /**
     * 通用请求
     *
     * @param appParam 请求参数 {@link KdzsObjectDTO}
     * @return {@link KdzsResponseDTO}
     */
    public static <T> KdzsResponseDTO<T> doRequest(KdzsObjectDTO appParam, KdzsMethodEnum kdzsMethod, TypeReference<T> dataType) {
        return doRequest(JSON.toJSONString(appParam), kdzsMethod, new TypeReference<KdzsResponseDTO<T>>(dataType.getType()){});
    }

    /**
     * 通用请求解析
     *
     * @param appParamJsonStr 请求参数JSON字符串
     * @param kdzsMethod {@link KdzsMethodEnum}
     * @return {@link KdzsResponseDTO}
     */
    private static <T> T doRequest(String appParamJsonStr, KdzsMethodEnum kdzsMethod, TypeReference<T> responseType) {
        if (Method.GET.equals(kdzsMethod.getHttpMethod())) {
            return doGet(appParamJsonStr, kdzsMethod.getValue(), responseType);
        }
        if (Method.POST.equals(kdzsMethod.getHttpMethod())) {
            return doPost(appParamJsonStr, kdzsMethod.getValue(), responseType);
        }
        throw new KdzsException("Unknow Kuaidizs Method, Please Check KdzsMethodEnum");
    }

    /**
     * 执行Post请求
     *
     * @param appParamJsonStr 请求参数JSON字符串
     * @param method 请求方法，参考 {@link KdzsMethodEnum}
     * @return {@link KdzsResponseDTO}
     */
    private static <T> T doPost(String appParamJsonStr, String method, TypeReference<T> responseType) {
        KdzsRequestDTO request = buildRequest(appParamJsonStr, method);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(request));
        Map<String, Object> innerMap = jsonObject.getInnerMap();
        String responseStr = HttpUtil.post(KdzsConstants.MethodUrl.COMMON_URL, innerMap);
        return JSON.parseObject(responseStr, responseType);
    }

    /**
     * 执行Get请求
     *
     * @param appParamJsonStr 请求参数JSON字符串
     * @param method 请求方法，参考 {@link KdzsMethodEnum}
     * @return {@link KdzsResponseDTO}
     */
    private static <T> T doGet(String appParamJsonStr, String method, TypeReference<T> responseType) {
        KdzsRequestDTO request = buildRequest(appParamJsonStr, method);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(request));
        Map<String, Object> innerMap = jsonObject.getInnerMap();
        String responseStr = HttpUtil.get(KdzsConstants.MethodUrl.COMMON_URL, innerMap);
        return JSON.parseObject(responseStr, responseType);
    }

    /**
     * 构建通用请求参数
     *
     * @param appParamJsonStr 请求参数JSON字符串
     * @param method 请求方法，参考 {@link KdzsMethodEnum}
     * @return {@link KdzsRequestDTO}
     */
    public static KdzsRequestDTO buildRequest(String appParamJsonStr, String method) {
        KdzsRequestDTO request = new KdzsRequestDTO();
        request.setAppKey(KdzsConfig.config().getAppKey());
        request.setMethod(method);
        request.setTimestamp(System.currentTimeMillis());
        request.setV(KdzsConfig.config().getVersion());
        request.setAppParam(appParamJsonStr);
        request.setSignMethod(KdzsConfig.config().getSignMethod());
        request.setSign(signRequestCommon(JSONObject.parseObject(appParamJsonStr), KdzsConfig.config().getAppSecret()));
        return request;
    }

    /**
     * 构建MD5加密请求对象
     *
     * @param params 请求参数JSON对象
     * @param appSecret 密钥
     * @return 加密字符串
     */
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
