package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.InstallmentConstant;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstallmentEntity {

    @SerializedName(InstallmentConstant.PAYMENT_METHOD_ID)
    public String paymentMethodId;

    @SerializedName(InstallmentConstant.PAYMENT_TYPE_ID)
    public String paymentTypeId;

    @SerializedName(InstallmentConstant.ISSUER)
    public CardIssuerEntity issuer;

    @SerializedName(InstallmentConstant.PAYER_COST)
    public List<PayerCostEntity> payerCost;
}
