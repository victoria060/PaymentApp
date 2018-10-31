package com.anaistroncoso.paymentapp.presentation.cardissuers;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {CardIssuerModule.class})
public interface CardIssuerComponent {
    void inject(CardIssuerFragment paymentFragment);

}
