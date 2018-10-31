package com.anaistroncoso.paymentapp.data.net;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaymentApiService {

    @GET("payment_methods")
    Observable<List<PaymentEntity>> getPaymentMethods();

    @GET("payment_methods/card_issuers")
    Observable<List<CardIssuerEntity>> getCardIssuers(@Query("payment_method_id") String paymentMethod);

    @GET("payment_methods/installments")
    Observable<List<InstallmentEntity>> getInstallments(
            @Query("amount") String ammount,
            @Query("payment_method_id") String paymentMethod,
            @Query("issuer.id") String issuerId);
}
