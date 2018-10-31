package com.anaistroncoso.paymentapp.domain.model.mapper;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PayerCostEntity;
import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;
import com.anaistroncoso.paymentapp.domain.model.InstallmentModel;
import com.anaistroncoso.paymentapp.domain.model.PayerCostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class InstallmentMapper extends Mapper<InstallmentModel, InstallmentEntity> {

    @Inject
    public InstallmentMapper() {
    }

    @Override
    public InstallmentEntity map(InstallmentModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InstallmentModel reverseMap(InstallmentEntity value) {
        InstallmentModel installmentModel = new InstallmentModel();
        installmentModel.paymentMethodId = value.paymentMethodId;
        installmentModel.paymentTypeId = value.paymentTypeId;
        installmentModel.issuer = reverseMapCardIssuer(value.issuer);
        installmentModel.payerCost = reverseMapPayerCosts(value.payerCost);
        return installmentModel;
    }

    private List<PayerCostModel> reverseMapPayerCosts(List<PayerCostEntity> payerCost) {
        List<PayerCostModel> list = new ArrayList<>();
        for (PayerCostEntity payerCostEntity : payerCost) {
            list.add(reverseMapPayerCost(payerCostEntity));
        }
        return list;
    }

    private PayerCostModel reverseMapPayerCost(PayerCostEntity payerCost) {
        PayerCostModel payerCostModel = new PayerCostModel();
        payerCostModel.installments = payerCost.installments;
        payerCostModel.installmentRate = payerCost.installmentRate;
        payerCostModel.labels = payerCost.labels;
        payerCostModel.minAllowedAmount = payerCost.minAllowedAmount;
        payerCostModel.maxAllowedAmount = payerCost.maxAllowedAmount;
        payerCostModel.recommendedMessage = payerCost.recommendedMessage;
        payerCostModel.installmentAmount = payerCost.installmentAmount;
        payerCostModel.totalAmount = payerCost.totalAmount;
        return payerCostModel;
    }

    private CardIssuerModel reverseMapCardIssuer(CardIssuerEntity issuer) {
        if (issuer == null)
            return null;
        CardIssuerModel cardIssuerModel = new CardIssuerModel();
        cardIssuerModel.id = issuer.id;
        cardIssuerModel.name = issuer.name;
        cardIssuerModel.secureThumbnail = issuer.secureThumbnail;
        cardIssuerModel.thumbnail = issuer.thumbnail;
        return cardIssuerModel;
    }
}
