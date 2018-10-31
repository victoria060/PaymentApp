package com.anaistroncoso.paymentapp.presentation.installment;

import com.anaistroncoso.paymentapp.domain.model.InstallmentModel;
import com.anaistroncoso.paymentapp.domain.usecase.UseCaseObserver;
import com.anaistroncoso.paymentapp.presentation.viewmodel.InstallmentViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.InstallmentMapper;

import java.util.List;

import javax.inject.Inject;


public class InstallmentObserver extends UseCaseObserver<InstallmentContract.View, List<InstallmentModel>> {

    private final InstallmentMapper installmentMapper;

    @Inject
    public InstallmentObserver(InstallmentMapper installmentMapper) {
        this.installmentMapper = installmentMapper;
    }

    @Override
    protected void onStart() {
        getView().showLoading();
    }

    @Override
    public void onComplete() {
        getView().hideLoading();
    }

    @Override
    public void onNext(List<InstallmentModel> installmentModels) {
        List<InstallmentViewModel> installmentViewModel = installmentMapper.reverseMap(installmentModels);
        if (installmentModels != null && !installmentModels.isEmpty()) {
            getView().showInstallments(installmentViewModel.get(0).payerCost);
        } else {
            getView().showEmptyInstallments();
        }

    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        getView().hideLoading();
        getView().showConnectionError();
    }


}
