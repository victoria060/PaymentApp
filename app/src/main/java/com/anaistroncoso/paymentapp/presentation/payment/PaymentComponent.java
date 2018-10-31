package com.anaistroncoso.paymentapp.presentation.payment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PaymentModule.class})
public interface PaymentComponent {
    void inject(PaymentFragment paymentFragment);

}
