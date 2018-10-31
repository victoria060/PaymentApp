package com.anaistroncoso.paymentapp.domain.usecase;

import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;
import com.anaistroncoso.paymentapp.data.repository.PaymentRepository;
import com.anaistroncoso.paymentapp.domain.model.PaymentModel;
import com.anaistroncoso.paymentapp.domain.model.mapper.PaymentMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class  GetPaymentUseCase extends UseCase<List<PaymentModel>> {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    @Inject
    public GetPaymentUseCase(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }


    @Override
    protected Observable<List<PaymentModel>> buildUseCaseObservable() {
        return paymentRepository.getPaymentMethods().map(new Function<List<PaymentEntity>, List<PaymentModel>>() {
            @Override
            public List<PaymentModel> apply(List<PaymentEntity> paymentEntity) throws Exception {
                return paymentMapper.reverseMap(paymentEntity);
            }
        });
    }
}