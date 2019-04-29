package com.sample.demo.retrofit_advance_demo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

internal interface ApiList {
    @POST("/v2/5cc2c1b33300008e007e541c")
    fun resultData(@Body request : DataResultRequest) : Call<DataResultResponse>
}