package com.anaistroncoso.paymentapp.data.repository.datasource;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.data.net.PaymentRestApi;
import com.anaistroncoso.paymentapp.data.net.PaymentRestApiImpl;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;


public class PaymentApiDataSourceTest extends BaseTest {

    @Mock
    PaymentRestApiImpl paymentRestApi;

    @InjectMocks
    PaymentApiDataSource paymentApiDataSource;


    @Test
    public void getPaymentMethods(){
        paymentApiDataSource.getPaymentMethods();
        verify(paymentRestApi.getPaymentMethods());
    }

    @Test
    public void getCardIssuers(){
        paymentApiDataSource.getCardIssuers("ammount");
        verify(paymentRestApi.getCardIssuers("ammount"));
    }

    @Test
    public void getInstallments(){
        paymentApiDataSource.getInstallments("ammount", "paymentMethod","issuerId");
        verify(paymentRestApi.getInstallments("ammount", "paymentMethod","issuerId"));
    }
}