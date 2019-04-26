package com.sample.demo.retrofit_advance_demo;

public class ApiListManager {
    public static ApiList getApiListManager(String url){
        return new AppClientManager(url).getClient().create(ApiList.class);
    }
    public static ApiList getApiListManager(){
        return new AppClientManager().getClient().create(ApiList.class);
    }
}
