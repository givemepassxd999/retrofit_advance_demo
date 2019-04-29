package com.sample.demo.retrofit_advance_demo

import android.arch.lifecycle.MutableLiveData
import com.sample.demo.retrofit_advance_demo.Config.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResultDataModel {
    fun resultData(request: DataResultRequest): MutableLiveData<DataResultResponse> {
        val memberLogoutRes = MutableLiveData<DataResultResponse>()
        ApiListManager.getApiListManager(BASE_URL).resultData(request)
            .enqueue(object : Callback<DataResultResponse> {

                override fun onResponse(call: Call<DataResultResponse>, response: Response<DataResultResponse>) {
                    val res = response.body() ?: DataResultResponse()
                    memberLogoutRes.value = res
                }

                override fun onFailure(call: Call<DataResultResponse>, t: Throwable) {
                    val failRes = DataResultResponse()
                    memberLogoutRes.value = failRes
                }
            })
        return memberLogoutRes
    }
}