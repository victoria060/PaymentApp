package com.anaistroncoso.paymentapp.data.di;

import android.content.Context;

import com.anaistroncoso.paymentapp.BuildConfig;
import com.anaistroncoso.paymentapp.data.net.PaymentRestApi;
import com.anaistroncoso.paymentapp.data.net.PaymentRestApiImpl;
import com.anaistroncoso.paymentapp.data.repository.PaymentApiRepository;
import com.anaistroncoso.paymentapp.data.repository.PaymentRepository;
import com.anaistroncoso.paymentapp.data.repository.datasource.PaymentApiDataSource;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public PaymentRepository providePaymentApiRepository(PaymentApiDataSource paymentApiDataSource) {
        return new PaymentApiRepository(paymentApiDataSource);
    }

    @Singleton
    @Provides
    public PaymentApiDataSource providePaymentApiDataSource(PaymentRestApi paymentRestApi) {
        return new PaymentApiDataSource(paymentRestApi);
    }

    @Singleton
    @Provides
    public PaymentRestApi providePaymentRestApi(Retrofit retrofit) {
        return new PaymentRestApiImpl(retrofit);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                                    RxJava2CallAdapterFactory factory,
                                    OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(factory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLogInterceptor = new HttpLoggingInterceptor();
            httpLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(httpLogInterceptor);
        }
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter("public_key", BuildConfig.PUBLIC_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });
        return client.build();
    }

    @Provides
    @Singleton
    public Cache providesOkhttpCache(Context context) {
        int cacheSize = 10 * 1024 * 1024; //10MB
        return new Cache(context.getCacheDir(), cacheSize);
    }


    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory providesGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public RxJava2CallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }
}
