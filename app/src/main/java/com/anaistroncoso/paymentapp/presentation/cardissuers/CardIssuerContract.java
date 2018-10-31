package com.anaistroncoso.paymentapp.presentation.cardissuers;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;

import java.util.List;

public interface CardIssuerContract {

    interface View extends BasePresenter.View {
        void showCardIssuers(List<CardIssuerViewModel> cardIssuerViewModel);

        void showEmptyCardIssuers();
    }

    interface Presenter {
        void getCardIssuers(String ammount);
    }
}
