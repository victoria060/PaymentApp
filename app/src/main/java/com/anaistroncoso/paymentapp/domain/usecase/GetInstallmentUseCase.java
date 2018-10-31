package com.anaistroncoso.paymentapp.domain.usecase;

import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.repository.PaymentRepository;
import com.anaistroncoso.paymentapp.domain.model.InstallmentModel;
import com.anaistroncoso.paymentapp.domain.model.mapper.InstallmentMapper;
import com.anaistroncoso.paymentapp.presentation.viewmodel.GetInstallmentsViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GetInstallmentUseCase extends UseCaseParam<List<InstallmentModel>, GetInstallmentsViewModel> {

    private final PaymentRepository paymentRepository;
    private final InstallmentMapper installmentMapper;

    @Inject
    public GetInstallmentUseCase(PaymentRepository paymentRepository, InstallmentMapper installmentMapper) {
        this.paymentRepository = paymentRepository;
        this.installmentMapper = installmentMapper;
    }


    @Override
    protected Observable<List<InstallmentModel>> buildUseCaseObservable(GetInstallmentsViewModel params) {
        return paymentRepository.getInstallments(params.amount, params.paymentMethodId, params.issuerId)
                .map(new Function<List<InstallmentEntity>, List<InstallmentModel>>() {
                    @Override
                    public List<InstallmentModel> apply(List<InstallmentEntity> installmentEntity) throws Exception {
                        return installmentMapper.reverseMap(installmentEntity);
                    }
                });
    }
}
