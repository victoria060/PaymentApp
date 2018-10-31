package com.anaistroncoso.paymentapp.domain.model.mapper;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;

import org.junit.Assert;
import org.junit.Test;

public class CardIssuerMapperTest extends BaseTest {

    @Test
    public void reverseMap() {
        CardIssuerMapper cardIssuerMapper = new CardIssuerMapper();
        CardIssuerEntity cardIssuerEntity = new CardIssuerEntity();
        cardIssuerEntity.id = "id";
        cardIssuerEntity.name = "name";
        cardIssuerEntity.secureThumbnail = "secureThumbnail";
        cardIssuerEntity.thumbnail = "thumbnail";
        CardIssuerModel cardIssuerModel = cardIssuerMapper.reverseMap(cardIssuerEntity);
        Assert.assertEquals("id", cardIssuerModel.id);
        Assert.assertEquals("name", cardIssuerModel.name);
        Assert.assertEquals("secureThumbnail", cardIssuerModel.secureThumbnail);
        Assert.assertEquals("thumbnail", cardIssuerModel.thumbnail);
    }

}