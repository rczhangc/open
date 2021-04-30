package org.open.boot.controller.sse.view;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author barnak
 */
public class Chater {

    private org.springframework.web.servlet.mvc.method.annotation.SseEmitter SseEmitter;

    public org.springframework.web.servlet.mvc.method.annotation.SseEmitter getSseEmitter() {
        return SseEmitter;
    }

    public void setSseEmitter(org.springframework.web.servlet.mvc.method.annotation.SseEmitter sseEmitter) {
        SseEmitter = sseEmitter;
    }
}
