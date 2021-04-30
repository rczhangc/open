package org.open.boot.service.netty.socket;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author barnak
 */
public class WebSocketUser {

    private static Map<String, List<Channel>> userNameWebsession = new ConcurrentHashMap<>();

    public static void add(String userName, Channel webSocketSession) {
        userNameWebsession.computeIfAbsent(userName, v -> new ArrayList<Channel>()).add(webSocketSession);
    }

    /**
     * 根据昵称拿WebSocketSession
     *
     * @param userName
     * @return
     */
    public static List<Channel> getSessionByUserName(String userName) {
        return userNameWebsession.get(userName);
    }

    /**
     * 移除失效的WebSocketSession
     *
     * @param webSocketSession
     */
    public static void removeWebSocketSession(String userName, Channel webSocketSession) {
        if (webSocketSession == null)
            return;
        List<Channel> webSessoin = userNameWebsession.get(userName);
        if (webSessoin == null || webSessoin.isEmpty())
            return;
        webSessoin.remove(webSocketSession);
    }

    public static Set<String> getUserList() {
        return userNameWebsession.keySet();
    }
}
