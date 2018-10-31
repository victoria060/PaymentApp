package com.anaistroncoso.paymentapp.presentation.viewmodel;

import java.util.List;

public class InstallmentViewModel {
    public String paymentMethodId;
    public String paymentTypeId;
    public CardIssuerViewModel issuer;
    public List<PayerCostViewModel> payerCost;
}
