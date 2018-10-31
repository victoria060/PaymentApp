package com.anaistroncoso.paymentapp.presentation.cardissuers;

import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;
import com.anaistroncoso.paymentapp.domain.usecase.UseCaseObserver;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.CardIssuerMapper;

import java.util.List;

import javax.inject.Inject;


public class CardIssuerObserver extends UseCaseObserver<CardIssuerContract.View, List<CardIssuerModel>> {

    private final CardIssuerMapper cardIssuerMapper;

    @Inject
    public CardIssuerObserver(CardIssuerMapper cardIssuerMapper) {
        this.cardIssuerMapper = cardIssuerMapper;
    }

    @Override
    protected void onStart() {
        getView().showLoading();
    }

    @Override
    public void onComplete() {
        getView().hideLoading();
    }

    @Override
    public void onNext(List<CardIssuerModel> cardIssuerModel) {
        List<CardIssuerViewModel> cardIssuerViewModel = cardIssuerMapper.reverseMap(cardIssuerModel);
        if (cardIssuerViewModel != null && !cardIssuerViewModel.isEmpty()) {
            getView().showCardIssuers(cardIssuerViewModel);
        }else{
            getView().showEmptyCardIssuers();
        }

    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        getView().hideLoading();
        getView().showConnectionError();
    }


}
