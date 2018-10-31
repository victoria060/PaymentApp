package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.SecurityCodeConstant;
import com.google.gson.annotations.SerializedName;

public class SecurityCodeEntity {
    @SerializedName(SecurityCodeConstant.MODE)
    String mode;
    @SerializedName(SecurityCodeConstant.LENGTH)
    int length;
    @SerializedName(SecurityCodeConstant.CARD_LOCATION)
    String cardLocation;
}
