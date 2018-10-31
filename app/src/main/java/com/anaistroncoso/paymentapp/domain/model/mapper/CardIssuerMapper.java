package com.anaistroncoso.paymentapp.domain.model.mapper;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;

import javax.inject.Inject;

public class CardIssuerMapper extends Mapper<CardIssuerModel, CardIssuerEntity> {

    @Inject
    CardIssuerMapper() {
    }

    @Override
    public CardIssuerEntity map(CardIssuerModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CardIssuerModel reverseMap(CardIssuerEntity value) {
        CardIssuerModel cardIssuerModel = new CardIssuerModel();
        cardIssuerModel.id = value.id;
        cardIssuerModel.name = value.name;
        cardIssuerModel.secureThumbnail = value.secureThumbnail;
        cardIssuerModel.thumbnail = value.thumbnail;
        return cardIssuerModel;
    }

}
