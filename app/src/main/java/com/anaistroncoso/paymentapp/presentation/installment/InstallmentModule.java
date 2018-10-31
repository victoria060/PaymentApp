package com.anaistroncoso.paymentapp.presentation.installment;

import android.content.Context;

import com.anaistroncoso.paymentapp.data.di.ImageModule;
import com.anaistroncoso.paymentapp.data.di.NetworkModule;
import com.anaistroncoso.paymentapp.domain.usecase.GetInstallmentUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.InstallmentMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class, ImageModule.class})
public class InstallmentModule {

    private final Context context;

    public InstallmentModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    public InstallmentPresenter providesInstallmentPresenter(GetInstallmentUseCase getInstallmentUseCase, InstallmentMapper installmentMapper, InstallmentObserver installmentObserver) {
        return new InstallmentPresenter(getInstallmentUseCase, installmentObserver);
    }

    @Provides
    @Singleton
    public InstallmentObserver providesInstallmentObserverObserver(InstallmentMapper installmentMapper) {
        return new InstallmentObserver(installmentMapper);
    }

    @Provides
    @Singleton
    public InstallmentAdapter providesPaymentAdapter() {
        return new InstallmentAdapter();
    }

}
