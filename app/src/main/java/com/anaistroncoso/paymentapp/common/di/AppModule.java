package com.anaistroncoso.paymentapp.common.di;

import android.app.Application;

import dagger.Module;

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

}
