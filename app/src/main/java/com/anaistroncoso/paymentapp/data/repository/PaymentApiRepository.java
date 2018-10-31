package com.anaistroncoso.paymentapp.data.repository;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;
import com.anaistroncoso.paymentapp.data.repository.datasource.PaymentDataSource;

import java.util.List;

import io.reactivex.Observable;

public class PaymentApiRepository implements PaymentRepository {

    private final PaymentDataSource paymentDataSource;

    public PaymentApiRepository(PaymentDataSource paymentDataSource) {
        this.paymentDataSource = paymentDataSource;
    }


    @Override
    public Observable<List<PaymentEntity>> getPaymentMethods() {
        return paymentDataSource.getPaymentMethods();
    }

    @Override
    public Observable<List<CardIssuerEntity>> getCardIssuers(String paymentMethod) {
        return paymentDataSource.getCardIssuers(paymentMethod);

    }

    @Override
    public Observable<List<InstallmentEntity>> getInstallments(String ammount, String paymentMethod, String issuerId) {
        return paymentDataSource.getInstallments(ammount,paymentMethod,issuerId);
    }
}
