package org.open.boot.controller.sse.view;

import java.util.HashMap;
import java.util.Map;

/**
 * @author barnak
 */
public class WebSSEUser {

    private static Map<String, Chater> userCahterMap = new HashMap<>();

    public WebSSEUser() {
        userCahterMap = new HashMap<>();
    }

    public static Chater getChater(String userName) {
        return userCahterMap.get(userName);
    }
}
