package org.open.boot.api.kuaidizs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 快递助手配置
 *
 * @author barnak
 */
@Configuration
@ConfigurationProperties(value = "kdzs")
public class KdzsConfig {

    private static KdzsConfig self;

    private String appKey;

    private String appSecret;

    private String version;

    private String signMethod;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public static KdzsConfig config() {
        return self;
    }

    @PostConstruct
    public void postConstruct() {
        self = this;
    }
}
