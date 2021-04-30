package org.open.boot.controller.netty;

import cn.hutool.core.util.RandomUtil;
import org.apache.catalina.Context;
import org.apache.catalina.Manager;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * @author barnak
 */
@Controller
public class IndexController {

    @GetMapping("netty")
    public String index(Model model, HttpServletRequest request){
        int currentNum = -1;
        try {
            int activeSessions = getActiveSessions(request);
            if (activeSessions == -1) {
                while(true){
                    Field requestFieldTop = getRequsest(request);
                    if(requestFieldTop == null)break;
                    requestFieldTop.setAccessible(true);
                    request = (HttpServletRequest) requestFieldTop.get(request);
                    activeSessions = getActiveSessions(request);
                    if(activeSessions != -1){
                        break;
                    }
                }

            }
            currentNum = activeSessions;
        } catch (Exception e) {
            currentNum = -2;
        }

        model.addAttribute("uid", RandomUtil.randomNumbers(6));
        model.addAttribute("currentNum", currentNum);
        return "socket";
    }

    @GetMapping("test")
    public String test(Model model, HttpServletRequest request){
        return "chat";
    }


    private int getActiveSessions(HttpServletRequest request) throws Exception {
        if (request instanceof RequestFacade) {
            Field requestField = request.getClass().getDeclaredField("request");
            requestField.setAccessible(true);
            Request req = (Request) requestField.get(request);
            Context context = req.getContext();
            Manager manager = context.getManager();
            int activeSessions = manager.getActiveSessions();
            return activeSessions;
        }
        return -1;
    }

    private Field getRequsest(HttpServletRequest request) {
        Class<?> className = request.getClass();
        for (; className != Object.class; className = className.getSuperclass()) {// 获取本身和父级对象
            try {
                Field requestFieldtmp = className.getDeclaredField("request");
                if (requestFieldtmp != null) {
                    return requestFieldtmp;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return null;
    }
}
