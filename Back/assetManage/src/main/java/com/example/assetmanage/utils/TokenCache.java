package com.example.assetmanage.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @author huang jiahui
 * @date 2021/9/23 9:15
 */
@Component
public class TokenCache {

    private static final LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public static void setToken(String userId, String token) {
        map.put(userId, token);
    }

    public static String getToken(String userId) {
        return map.get(userId);
    }

    @Scheduled(fixedRate = 1000 * 60 * 20)
    public static void clearFirst() {
        System.out.println("执行了定时");
        if (!map.isEmpty()) {
            String key = map.entrySet().iterator().next().getKey();
            map.remove(key);
        }
    }

    public static boolean isEmpty() {
        return map.isEmpty();
    }
}
