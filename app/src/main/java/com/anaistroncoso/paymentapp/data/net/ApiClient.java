package com.anaistroncoso.paymentapp.data.net;

import retrofit2.Retrofit;

public abstract class ApiClient<T> {

    protected T apiService;

    Retrofit retrofit;

    public void ApiClient() {
        apiService = retrofit.create(getApiService());
    }

    protected abstract Class<T> getApiService();

}
