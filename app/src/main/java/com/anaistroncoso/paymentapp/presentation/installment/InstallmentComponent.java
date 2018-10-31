package com.anaistroncoso.paymentapp.presentation.installment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {InstallmentModule.class})
public interface InstallmentComponent {
    void inject(InstallmentFragment installmentFragment);

}
