package com.five88.models.response;

import com.google.gson.annotations.SerializedName;

public class TelegramResp {

    @SerializedName("result")
    public Result result;
    @SerializedName("ok")
    public boolean ok;

    public static class Result {
        @SerializedName("text")
        public String text;
        @SerializedName("date")
        public int date;
        @SerializedName("chat")
        public Chat chat;
        @SerializedName("from")
        public From from;
        @SerializedName("message_id")
        public int message_id;
    }

    public static class Chat {
        @SerializedName("all_members_are_administrators")
        public boolean all_members_are_administrators;
        @SerializedName("type")
        public String type;
        @SerializedName("title")
        public String title;
        @SerializedName("id")
        public int id;
    }

    public static class From {
        @SerializedName("username")
        public String username;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("is_bot")
        public boolean is_bot;
        @SerializedName("id")
        public int id;
    }
}
