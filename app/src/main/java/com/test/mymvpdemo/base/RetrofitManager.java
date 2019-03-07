package com.test.mymvpdemo.base;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private Retrofit retrofit;

    private RetrofitManager() {
        String baseUrl = "https://www.apiopen.top/";
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl).client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    private static RetrofitManager getInstance() {
        return RetrofitInstance.instance;
    }

    private static class RetrofitInstance {
        private static RetrofitManager instance = new RetrofitManager();
    }

    public static <T> T getService(Class<T> tClass) {
        return RetrofitManager.getInstance().retrofit.create(tClass);
    }

}