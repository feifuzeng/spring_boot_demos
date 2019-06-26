package com.github.feifuzeng.style.utils;

import lombok.extern.log4j.Log4j2;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

/**
 * @author feifz
 * @version 1.0.0
 * @Description http工具类，基于okhttp3
 * @createTime 2019年06月06日 09:30:00
 */
@Log4j2
public class HttpUtil {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");


    /**
     * 同步get方式请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String doGet(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }

    /**
     * 异步get方式请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static void doSyncGet(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new OkHttpCallback());
    }

    /**
     * 同步post方式请求-json提交参数
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String doPost(String url, final String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }

    }

    /**
     * 异步post方式请求-json提交参数
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static void doSyncPost(String url, final String json) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new OkHttpCallback());

    }

    /**
     * 同步post方式请求-form表单提交参数
     *
     * @param url
     * @param paramsMap
     * @return
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> paramsMap) throws IOException {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            builder.add(key, paramsMap.get(key));
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }

    }

    /**
     * 异步post方式请求-form表单提交参数
     *
     * @param url
     * @param paramsMap
     * @return
     * @throws IOException
     */
    public static void doSyncPost(String url, Map<String, String> paramsMap) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            builder.add(key, paramsMap.get(key));
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new OkHttpCallback());

    }

    /**
     * okhttp 异步调用回调函数
     */
    static class OkHttpCallback implements Callback {
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
            log.error(e);
        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            if (response.isSuccessful()) {
                log.info("Successful data acquisition . . . ");
                log.info("response.code()==" + response.code());
                log.info("response.body().string()==" + response.body().string());
            }
        }
    }


}
