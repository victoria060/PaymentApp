package com.anaistroncoso.paymentapp.domain.usecase;

import com.anaistroncoso.paymentapp.data.entity.CardIssuerEntity;
import com.anaistroncoso.paymentapp.data.repository.PaymentRepository;
import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;
import com.anaistroncoso.paymentapp.domain.model.mapper.CardIssuerMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GetCardIssuerUseCase extends UseCaseParam<List<CardIssuerModel>, String> {

    private final PaymentRepository paymentRepository;
    private final CardIssuerMapper cardIssuerMapper;

    @Inject
    public GetCardIssuerUseCase(PaymentRepository paymentRepository, CardIssuerMapper cardIssuerMapper) {
        this.paymentRepository = paymentRepository;
        this.cardIssuerMapper = cardIssuerMapper;
    }

    @Override
    protected Observable<List<CardIssuerModel>> buildUseCaseObservable(String paymentMethodId) {
        return paymentRepository.getCardIssuers(paymentMethodId).map(new Function<List<CardIssuerEntity>, List<CardIssuerModel>>() {
            @Override
            public List<CardIssuerModel> apply(List<CardIssuerEntity> cardIssuerEntity) throws Exception {
                return cardIssuerMapper.reverseMap(cardIssuerEntity);
            }
        });
    }
}
