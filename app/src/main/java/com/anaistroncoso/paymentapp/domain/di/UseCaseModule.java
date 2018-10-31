package com.anaistroncoso.paymentapp.domain.di;

import com.anaistroncoso.paymentapp.data.di.NetworkModule;
import com.anaistroncoso.paymentapp.data.repository.PaymentApiRepository;
import com.anaistroncoso.paymentapp.domain.model.mapper.CardIssuerMapper;
import com.anaistroncoso.paymentapp.domain.model.mapper.InstallmentMapper;
import com.anaistroncoso.paymentapp.domain.model.mapper.PaymentMapper;
import com.anaistroncoso.paymentapp.domain.usecase.GetCardIssuerUseCase;
import com.anaistroncoso.paymentapp.domain.usecase.GetInstallmentUseCase;
import com.anaistroncoso.paymentapp.domain.usecase.GetPaymentUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
public class UseCaseModule {

    @Singleton
    @Provides
    public GetCardIssuerUseCase provideGetCardIssuerUseCase(PaymentApiRepository paymentRepository, CardIssuerMapper cardIssuerMapper) {
        return new GetCardIssuerUseCase(paymentRepository, cardIssuerMapper);
    }

    @Singleton
    @Provides
    public GetPaymentUseCase provideGetPaymentUseCase(PaymentApiRepository paymentRepository, PaymentMapper paymentMapper) {
        return new GetPaymentUseCase(paymentRepository, paymentMapper);
    }

    @Singleton
    @Provides
    public GetInstallmentUseCase provideInstallmentUseCase(PaymentApiRepository paymentRepository, InstallmentMapper installmentMapper) {
        return new GetInstallmentUseCase(paymentRepository, installmentMapper);
    }


}
