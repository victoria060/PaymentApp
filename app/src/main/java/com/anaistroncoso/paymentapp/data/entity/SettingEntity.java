package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.SettingConstant;
import com.google.gson.annotations.SerializedName;

public class SettingEntity {
    @SerializedName(SettingConstant.CARD_NUMBER)
    public CardNumberEntity paymentCardNumber;
}
