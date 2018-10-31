package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.CardNumberConstant;
import com.google.gson.annotations.SerializedName;

public class CardNumberEntity {

    @SerializedName(CardNumberConstant.LENGTH)
    public String length;

    @SerializedName(CardNumberConstant.VALIDATION)
    public String validation;

}
