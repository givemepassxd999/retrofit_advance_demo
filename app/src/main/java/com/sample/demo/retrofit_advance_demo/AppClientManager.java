package com.sample.demo.retrofit_advance_demo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class AppClientManager {
    public static final int requestApiTimeOut = 10;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    public AppClientManager(){
        okHttpClient = createOkHttpClient();
        retrofit = createClient();
    }

    public AppClientManager(String url){
        okHttpClient = createOkHttpClient();
        retrofit = createClient(url);
    }

    private OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(requestApiTimeOut, TimeUnit.SECONDS)
                .writeTimeout(requestApiTimeOut, TimeUnit.SECONDS)
                .readTimeout(requestApiTimeOut, TimeUnit.SECONDS)
                .build();
    }

    public Retrofit createClient(){
        return new Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();
    }

    public Retrofit createClient(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public Retrofit getClient(){
        return retrofit;
    }
}
