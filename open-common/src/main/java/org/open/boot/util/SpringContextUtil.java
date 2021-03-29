package org.open.boot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author barnak
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    public SpringContextUtil() {
        System.out.println("SpringContextUtil 进行初始化");
    }

    private static SpringContextUtil THIS;

    private ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return THIS.applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    @PostConstruct
    public void init() {
        THIS = this;
    }
}
