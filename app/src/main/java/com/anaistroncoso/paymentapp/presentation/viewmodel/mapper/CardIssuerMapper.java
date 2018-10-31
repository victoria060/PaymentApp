package com.anaistroncoso.paymentapp.presentation.viewmodel.mapper;


import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;
import com.anaistroncoso.paymentapp.domain.model.mapper.Mapper;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;

import javax.inject.Inject;

public class CardIssuerMapper extends Mapper<CardIssuerViewModel, CardIssuerModel> {

    @Inject
    public CardIssuerMapper(){
    }

    @Override
    public CardIssuerModel map(CardIssuerViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CardIssuerViewModel reverseMap(CardIssuerModel value) {
        CardIssuerViewModel cardIssuerViewModel = new CardIssuerViewModel();
        cardIssuerViewModel.id = value.id;
        cardIssuerViewModel.name = value.name;
        cardIssuerViewModel.secureThumbnail = value.secureThumbnail;
        cardIssuerViewModel.thumbnail = value.thumbnail;
        return cardIssuerViewModel;
    }

}
