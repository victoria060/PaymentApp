package com.anaistroncoso.paymentapp.presentation.viewmodel.mapper;

import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;
import com.anaistroncoso.paymentapp.domain.model.InstallmentModel;
import com.anaistroncoso.paymentapp.domain.model.PayerCostModel;
import com.anaistroncoso.paymentapp.domain.model.mapper.Mapper;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.InstallmentViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PayerCostViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class InstallmentMapper extends Mapper<InstallmentViewModel, InstallmentModel> {
    @Inject
    public InstallmentMapper() {
    }

    @Override
    public InstallmentModel map(InstallmentViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InstallmentViewModel reverseMap(InstallmentModel value) {
        InstallmentViewModel installmentViewModel = new InstallmentViewModel();
        installmentViewModel.paymentMethodId = value.paymentMethodId;
        installmentViewModel.paymentTypeId = value.paymentTypeId;
        installmentViewModel.issuer = reverseMapCardIssuer(value.issuer);
        installmentViewModel.payerCost = reverseMapPayerCosts(value.payerCost);
        return installmentViewModel;
    }

    private List<PayerCostViewModel> reverseMapPayerCosts(List<PayerCostModel> payerCostModels) {
        List<PayerCostViewModel> list = new ArrayList<>();
        for (PayerCostModel payerCostModel : payerCostModels) {
            list.add(reverseMapPayerCost(payerCostModel));
        }
        return list;
    }
    private PayerCostViewModel reverseMapPayerCost(PayerCostModel payerCost) {
        PayerCostViewModel payerCostViewModel = new PayerCostViewModel();
        payerCostViewModel.installments = payerCost.installments;
        payerCostViewModel.installmentRate = payerCost.installmentRate;
        payerCostViewModel.labels = payerCost.labels;
        payerCostViewModel.minAllowedAmount = payerCost.minAllowedAmount;
        payerCostViewModel.maxAllowedAmount = payerCost.maxAllowedAmount;
        payerCostViewModel.recommendedMessage = payerCost.recommendedMessage;
        payerCostViewModel.installmentAmount = payerCost.installmentAmount;
        payerCostViewModel.totalAmount = payerCost.totalAmount;
        return payerCostViewModel;
    }

    private CardIssuerViewModel reverseMapCardIssuer(CardIssuerModel issuer) {
        CardIssuerViewModel cardIssuerViewModel = new CardIssuerViewModel();
        cardIssuerViewModel.id = issuer.id;
        cardIssuerViewModel.name = issuer.name;
        cardIssuerViewModel.secureThumbnail = issuer.secureThumbnail;
        cardIssuerViewModel.thumbnail = issuer.thumbnail;
        return cardIssuerViewModel;
    }
}
