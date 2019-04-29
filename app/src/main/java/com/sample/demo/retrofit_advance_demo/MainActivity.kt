package com.sample.demo.retrofit_advance_demo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ResultViewModel
    private lateinit var resultDataModel : ResultDataModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultDataModel = ResultDataModel()
        viewModel = ViewModelProviders.of(this, ResultFactory(resultDataModel)).get(ResultViewModel::class.java)
        send_data.setOnClickListener {
            viewModel.resultData("aa").observe(this@MainActivity, Observer {
                Log.e("", it?.result)
                info.text = it?.result
            })
        }

    }

}
