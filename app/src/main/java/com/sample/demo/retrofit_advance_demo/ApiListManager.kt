package com.sample.demo.retrofit_advance_demo

object ApiListManager {

    internal fun getApiListManager(url: String): ApiList {
        return AppClientManager(url).client.create(ApiList::class.java)
    }
}
