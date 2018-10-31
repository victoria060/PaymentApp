package com.anaistroncoso.paymentapp.data.repository.datasource;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;

import java.util.List;

import io.reactivex.Observable;

public interface PaymentDataSource {

    Observable<List<PaymentEntity>> getPaymentMethods();

    Observable<List<CardIssuerEntity>> getCardIssuers(String paymentMethod);

    Observable<List<InstallmentEntity>> getInstallments(String ammount, String paymentMethod, String issuerId);

}
