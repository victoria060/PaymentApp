package com.anaistroncoso.paymentapp.presentation.payment;

import android.content.Context;

import com.anaistroncoso.paymentapp.data.di.ImageModule;
import com.anaistroncoso.paymentapp.data.di.NetworkModule;
import com.anaistroncoso.paymentapp.domain.usecase.GetPaymentUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.PaymentMapper;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class,ImageModule.class})
public class PaymentModule {

    private final Context context;

    public PaymentModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    public PaymentPresenter providesPaymentPresenter(GetPaymentUseCase getPaymentUseCase, PaymentMapper paymentMapper, PaymentObserver paymentObserver) {
        return new PaymentPresenter(getPaymentUseCase,paymentMapper, paymentObserver);
    }

    @Provides
    @Singleton
    public PaymentObserver providesPaymentObserver(PaymentMapper paymentMapper) {
        return new PaymentObserver(paymentMapper);
    }

    @Provides
    @Singleton
    public PaymentAdapter providesPaymentAdapter(Picasso picasso) {
        return new PaymentAdapter(picasso);
    }

}
