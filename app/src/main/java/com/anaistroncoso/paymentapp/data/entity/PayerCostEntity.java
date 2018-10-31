package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.PayerCostConstant;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PayerCostEntity {
    @SerializedName(PayerCostConstant.INSTALLMENTS)
    public int installments;

    @SerializedName(PayerCostConstant.INSTALLMENT_RATE)
    public float installmentRate;

    @SerializedName(PayerCostConstant.LABELS)
    public List<String> labels;

    @SerializedName(PayerCostConstant.MIN_ALLOWED_AMMOUNT)
    public float minAllowedAmount;

    @SerializedName(PayerCostConstant.MAX_ALLOWED_AMMOUNT)
    public int maxAllowedAmount;

    @SerializedName(PayerCostConstant.RECOMMEND_MESSAGE)
    public String recommendedMessage;

    @SerializedName(PayerCostConstant.INSTALLMENT_AMOUNT)
    public float installmentAmount;

    @SerializedName(PayerCostConstant.TOTAL_AMOUNT)
    public float totalAmount;
}
