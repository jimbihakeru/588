package com.five88.utils;

import com.five88.network.OkHttpUtil;
import org.apache.http.util.TextUtils;

import java.io.File;

public class TelegramUtil {
    private static TelegramUtil instance;

    private static final String TOKEN = "772733429:AAHucXHWQvwnHbhmJJLTyJ4P-Jo7rhXqCIQ";

    public static TelegramUtil getInstance() {
        if (instance == null)
            instance = new TelegramUtil();
        return instance;
    }

    public void sendMessage(AppEnum.ChannelType channelType, String message) {
        try {
            String chatId = channelType.toString();
            if (Constant.DEBUG && channelType == AppEnum.ChannelType.FIVE88_BUG_GROUP)
                chatId = AppEnum.ChannelType.AUTO_TOOL_DEBUG_GROUP.toString();

            String url = String.format("https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s", TOKEN, chatId, message);

            String result = OkHttpUtil.getInstance().get(url);
            if (TextUtils.isEmpty(result)) Util.log("Telegram Send Message Error");
        } catch (Exception ex) {
            // ex.printStackTrace();
            sendException("TelegramUtil_sendMessage", ex);
        }
    }

    public static void sendException(String tracking, Exception ex) {
        if (ex != null) {
            TelegramUtil telegramUtil = TelegramUtil.getInstance();
            String message = ex.getMessage();
            message = String.format("[%s][%s] %s", Constant.APP_NAME, tracking, message);
            telegramUtil.sendMessage(AppEnum.ChannelType.FIVE88_BUG_GROUP, message);
        }
    }

    public void sendPhoto(File file, String message) {
        try {
            String url = String.format("https://api.telegram.org/bot%s/sendphoto", TOKEN);
            String chatId = Constant.DEBUG ? AppEnum.ChannelType.AUTO_TOOL_DEBUG_GROUP.toString() : AppEnum.ChannelType.FIVE88_BUG_GROUP.toString();
            String result = OkHttpUtil.getInstance().sendPhoto(url, chatId, file, message);
            if (TextUtils.isEmpty(result)) Util.log("Telegram Send Message Error");
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
    }
}
