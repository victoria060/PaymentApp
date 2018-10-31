package com.anaistroncoso.paymentapp.data.net;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PaymentRestApiImpl extends ApiClient<PaymentApiService> implements PaymentRestApi {

    public PaymentRestApiImpl(Retrofit retrofit) {
        apiService = retrofit.create(getApiService());
    }

    @Override
    public Observable<List<PaymentEntity>> getPaymentMethods() {
        return apiService.getPaymentMethods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<CardIssuerEntity>> getCardIssuers(String paymentMethod) {
        return apiService.getCardIssuers(paymentMethod)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<InstallmentEntity>> getInstallments(String ammount, String paymentMethod, String issuerId) {
        return apiService.getInstallments(ammount, paymentMethod, issuerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    protected Class<PaymentApiService> getApiService() {
        return PaymentApiService.class;
    }
}
