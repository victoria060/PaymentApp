package com.anaistroncoso.paymentapp.presentation.viewmodel;

import java.util.List;

public class PayerCostViewModel {
    public int installments;
    public float installmentRate;
    public List<String> labels;
    public float minAllowedAmount;
    public int maxAllowedAmount;
    public String recommendedMessage;
    public float installmentAmount;
    public float totalAmount;
}
