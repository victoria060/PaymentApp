package com.anaistroncoso.paymentapp.domain.model;

import java.util.List;

public class PayerCostModel {
    public int installments;
    public float installmentRate;
    public List<String> labels;
    public float minAllowedAmount;
    public int maxAllowedAmount;
    public String recommendedMessage;
    public float installmentAmount;
    public float totalAmount;
}
