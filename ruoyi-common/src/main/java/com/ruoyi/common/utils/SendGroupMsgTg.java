package com.ruoyi.common.utils;

import com.ruoyi.common.utils.http.HttpUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tg")
public class SendGroupMsgTg {
    private static String uri;
    private static String chatId;
    private static String techChatId;

    public static String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        SendGroupMsgTg.uri = uri;
    }

    public static String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        SendGroupMsgTg.chatId = chatId;
    }

    public static String getTechChatId() {
        return techChatId;
    }

    public void setTechChatId(String techChatId) {
        SendGroupMsgTg.techChatId = techChatId;
    }

    public static void sendGroupMsgTg(String msg) {
        HttpUtils.sendPost(uri, String.format("chat_id=%s&text=%s",chatId,msg));
    }

    public static void sendGroupMsgTgTech(String msg) {
        HttpUtils.sendPost(uri, String.format("chat_id=%s&text=%s",techChatId,msg));
    }
}
