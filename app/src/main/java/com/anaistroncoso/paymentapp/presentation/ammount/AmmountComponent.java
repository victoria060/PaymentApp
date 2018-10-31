package com.anaistroncoso.paymentapp.presentation.ammount;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AmmountModule.class)
public interface AmmountComponent {
    void inject(AmmountFragment ammountFragment);
}
