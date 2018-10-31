package com.anaistroncoso.paymentapp.data.repository.datasource;


import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;
import com.anaistroncoso.paymentapp.data.net.PaymentRestApi;

import java.util.List;

import io.reactivex.Observable;

public class PaymentApiDataSource implements PaymentDataSource {

    private PaymentRestApi paymentRestApi;

    public PaymentApiDataSource(PaymentRestApi paymentRestApi) {
        this.paymentRestApi = paymentRestApi;
    }

    @Override
    public Observable<List<PaymentEntity>> getPaymentMethods() {
        return paymentRestApi.getPaymentMethods();
    }

    @Override
    public Observable<List<CardIssuerEntity>> getCardIssuers(String paymentMethod) {
        return paymentRestApi.getCardIssuers(paymentMethod);

    }

    @Override
    public Observable<List<InstallmentEntity>> getInstallments(String ammount, String paymentMethod, String issuerId) {
        return paymentRestApi.getInstallments(ammount,paymentMethod,issuerId);
    }

}
