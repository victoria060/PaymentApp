package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.CardIssuerConstant;
import com.google.gson.annotations.SerializedName;

public class CardIssuerEntity {

    @SerializedName(CardIssuerConstant.ID)
    public String id;

    @SerializedName(CardIssuerConstant.NAME)
    public String name;

    @SerializedName(CardIssuerConstant.SECURE_THUMBNAIL)
    public String secureThumbnail;

    @SerializedName(CardIssuerConstant.THUMBNAIL)
    public String thumbnail;
}
