package com.anaistroncoso.paymentapp.presentation.payment;

import com.anaistroncoso.paymentapp.domain.model.PaymentModel;
import com.anaistroncoso.paymentapp.domain.usecase.UseCaseObserver;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.PaymentMapper;

import java.util.List;

import javax.inject.Inject;


public class PaymentObserver extends UseCaseObserver<PaymentContract.View, List<PaymentModel>> {

    private final PaymentMapper paymentMapper;

    @Inject
    public PaymentObserver(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
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
    public void onNext(List<PaymentModel> paymentModel) {
        List<PaymentViewModel> paymentViewModel = paymentMapper.reverseMap(paymentModel);
        if (paymentViewModel != null && !paymentViewModel.isEmpty()) {
            getView().showPaymentMethod(paymentViewModel);
        } else {
            getView().showEmptyPayment();
        }
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        getView().hideLoading();
        getView().showConnectionError();
    }


}
