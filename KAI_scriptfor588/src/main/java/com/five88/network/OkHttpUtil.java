package com.five88.network;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {

    public interface DataRequestCallback {
        void callback(String result, Exception ex);
    }

    private static OkHttpUtil instance;

    static OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS);

    static OkHttpClient client = builder.build();

    public static OkHttpUtil getInstance() {
        if (instance == null)
            instance = new OkHttpUtil();
        return instance;
    }

    public void get(String url, final DataRequestCallback callback) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                callback.callback(result, null);
            }

            public void onFailure(Call call, IOException ex) {
                // ex.printStackTrace();
                callback.callback(null, ex);
            }
        });
    }

    public String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String sendPhoto(String url, String chatId, File file, String message) throws Exception {
        String ImagePath = file.getAbsolutePath();

        final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");

        String filename = ImagePath.substring(ImagePath.lastIndexOf("/") + 1);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("photo", filename, RequestBody.create(MEDIA_TYPE_PNG, file))
                .addFormDataPart("chat_id", chatId)
                .addFormDataPart("caption", message)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
