package com.sample.demo.retrofit_advance_demo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class ResultViewModel constructor(private val resultDataModel: ResultDataModel) : ViewModel(){
    fun resultData(data:String): MutableLiveData<DataResultResponse> {
        val request = DataResultRequest(data)

        return resultDataModel.resultData(request)
    }
}