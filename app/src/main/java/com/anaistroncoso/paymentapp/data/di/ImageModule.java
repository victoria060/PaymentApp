package com.anaistroncoso.paymentapp.data.di;

import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ImageModule {

    @Provides
    @Singleton
    public OkHttp3Downloader providesOkhttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    @Singleton
    public Picasso providesPicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }
}
