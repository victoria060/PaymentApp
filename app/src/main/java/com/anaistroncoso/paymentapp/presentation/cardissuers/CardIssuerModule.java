package com.anaistroncoso.paymentapp.presentation.cardissuers;

import android.content.Context;

import com.anaistroncoso.paymentapp.data.di.ImageModule;
import com.anaistroncoso.paymentapp.data.di.NetworkModule;
import com.anaistroncoso.paymentapp.domain.usecase.GetCardIssuerUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.CardIssuerMapper;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class,ImageModule.class})
public class CardIssuerModule {

    private final Context context;

    public CardIssuerModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    public CardIssuerPresenter providesCardIssuerPresenter(GetCardIssuerUseCase getCardIssuerUseCase, CardIssuerMapper cardIssuerMapper, CardIssuerObserver cardIssuerObserver) {
        return new CardIssuerPresenter(getCardIssuerUseCase,cardIssuerMapper, cardIssuerObserver);
    }

    @Provides
    @Singleton
    public CardIssuerObserver providesPaymentObserver(CardIssuerMapper cardIssuerMapper) {
        return new CardIssuerObserver(cardIssuerMapper);
    }

    @Provides
    @Singleton
    public CardIssuerAdapter providesPaymentAdapter(Picasso picasso) {
        return new CardIssuerAdapter(picasso);
    }

}
