package org.open.boot.propagation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author barnak
 */
public class PropagationFactory {

    public static PropagationExecute getService(Propagation propagation, Runnable runnable) throws Exception {
        try {

            PropagationExecute service = new PropagationExecute() {
                @Override
                @Transactional(rollbackFor = Exception.class)
                public void start() {
                    runnable.run();
                }
            };
            // 获取方法注解
            Method method = service.getClass().getMethod("start");
            Transactional annotation = method.getAnnotation(Transactional.class);

            InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
            // 获取 AnnotationInvocationHandler 的 memberValues 字段
            Field hField = invocationHandler.getClass().getDeclaredField("memberValues");
            // 因为这个字段事 private final 修饰，所以要打开权限
            hField.setAccessible(true);
            // 获取 memberValues
            Map<String,Object> memberValues = (Map<String,Object>) hField.get(invocationHandler);
            // 修改 value 属性值
            memberValues.put("propagation", propagation);
            return service;
        } catch (Exception e) {
            throw new Exception("sdsdds");
        }
    }
}
