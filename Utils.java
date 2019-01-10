package com.example.jrz.android_shixun;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by jrz on 2019/1/4.
 */

public class Utils {
    private static final String URL="http://123.207.85.214/chat/member.php";
    private static final String LoginURL = "http://123.207.85.214/chat/login.php";

    public static void GetContacts(okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()//建设者
        .url(URL)
        .build();
        client.newCall(request).enqueue(callback);
    }
    public static void postLogin(String username, String password, Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("user",username)
                .add("password",password)
                .build();
        Request request = new Request.Builder()
                .url(LoginURL)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
