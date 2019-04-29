package com.sample.demo.retrofit_advance_demo

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

class AppClientManager {
    val requestApiTimeOut = 10
    var client: Retrofit
    private var okHttpClient: OkHttpClient? = null

    constructor() {
        okHttpClient = createOkHttpClient()
        client = createClient()
    }

    constructor(url: String) {
        okHttpClient = createOkHttpClient()
        client = createClient(url)
    }

    private fun createOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(requestApiTimeOut.toLong(), TimeUnit.SECONDS)
            .writeTimeout(requestApiTimeOut.toLong(), TimeUnit.SECONDS)
            .readTimeout(requestApiTimeOut.toLong(), TimeUnit.SECONDS)
            .build()
    }

    fun createClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient!!)
            .build()
    }

    fun createClient(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient!!)
            .build()
    }
}
