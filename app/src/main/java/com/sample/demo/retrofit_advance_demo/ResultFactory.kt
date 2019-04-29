package com.sample.demo.retrofit_advance_demo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ResultFactory(private val resultDataModel: ResultDataModel) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ResultViewModel(resultDataModel) as T
    }
}