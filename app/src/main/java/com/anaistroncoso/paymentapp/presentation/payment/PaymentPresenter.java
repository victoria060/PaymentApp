package com.anaistroncoso.paymentapp.presentation.payment;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;
import com.anaistroncoso.paymentapp.domain.usecase.GetPaymentUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.PaymentMapper;

import javax.inject.Inject;

public class PaymentPresenter extends BasePresenter<PaymentContract.View> implements PaymentContract.Presenter {

    private final PaymentMapper paymentMapper;
    private final GetPaymentUseCase getPaymentUseCase;
    private final PaymentObserver paymentObserver;

    @Inject
    public PaymentPresenter(GetPaymentUseCase getPaymentUseCase, PaymentMapper paymentMapper, PaymentObserver paymentObserver) {
        this.paymentMapper = paymentMapper;
        this.getPaymentUseCase = getPaymentUseCase;
        this.paymentObserver = paymentObserver;
        registerUseCase(this.getPaymentUseCase);
    }

    @Override
    public void getPaymentMethod(String ammount) {
        paymentObserver.attachView(getView());
        getPaymentUseCase.execute(paymentObserver);
    }
}
