package com.anaistroncoso.paymentapp.presentation.cardissuers;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;
import com.anaistroncoso.paymentapp.domain.usecase.GetCardIssuerUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.CardIssuerMapper;

import javax.inject.Inject;

public class CardIssuerPresenter extends BasePresenter<CardIssuerContract.View> implements CardIssuerContract.Presenter {

    private final CardIssuerMapper cardIssuerMapper;
    private final GetCardIssuerUseCase getCardIssuerUseCase;
    private final CardIssuerObserver cardIssuerObserver;

    @Inject
    public CardIssuerPresenter(GetCardIssuerUseCase getCardIssuerUseCase, CardIssuerMapper cardIssuerMapper, CardIssuerObserver cardIssuerObserver) {
        this.getCardIssuerUseCase = getCardIssuerUseCase;
        this.cardIssuerMapper = cardIssuerMapper;
        this.cardIssuerObserver = cardIssuerObserver;
        registerUseCase(this.getCardIssuerUseCase);
    }

    @Override
    public void getCardIssuers(String ammount) {
        cardIssuerObserver.attachView(getView());
        getCardIssuerUseCase.execute(cardIssuerObserver, ammount);
    }
}
