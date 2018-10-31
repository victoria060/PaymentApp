package com.anaistroncoso.paymentapp.domain.model;

import java.util.List;

public class InstallmentModel {
    public String paymentMethodId;
    public String paymentTypeId;
    public CardIssuerModel issuer;
    public List<PayerCostModel> payerCost;
}
