package org.open.boot.controller.sse;

import lombok.extern.slf4j.Slf4j;
import org.open.boot.controller.sse.request.MessageDTO;
import org.open.boot.controller.sse.view.Chater;
import org.open.boot.controller.sse.view.ResultModel;
import org.open.boot.controller.sse.view.WebSSEUser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author barnak
 */
@Slf4j
@Controller
public class SseController {

    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter to(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        // 超时时间设置为3分钟
        SseEmitter sseEmitter = new SseEmitter(180000L);
        Chater chater = WebSSEUser.getChater(userName);
        sseEmitter.onTimeout(() -> chater.setSseEmitter(null));
        sseEmitter.onCompletion(() -> System.out.println("完成！！！"));
        chater.setSseEmitter(sseEmitter);
        return sseEmitter;
    }

    @RequestMapping(value = "/send")
    public ResultModel send(@RequestBody MessageDTO<String> messageDTO, HttpServletRequest request) {
        log.info("收到发往用户[{}]的文本请求;", messageDTO.getTargetUserName());
        Object userName = request.getSession().getAttribute("userName");
        if (userName == null)
            return ResultModel.error("无用户");
        messageDTO.setFromUserName((String) userName);
        messageDTO.setMessageType(1);
        Chater chater = WebSSEUser.getChater(messageDTO.getTargetUserName());
        try {
            chater.getSseEmitter().send(messageDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultModel.ok();
    }
}
