package com.anaistroncoso.paymentapp.presentation.payment;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.domain.usecase.GetPaymentUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.PaymentMapper;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class PaymentPresenterTest extends BaseTest {

    @Mock
    PaymentMapper paymentMapper;
    @Mock
    GetPaymentUseCase getPaymentUseCase;
    @Mock
    PaymentObserver paymentObserver;
    @InjectMocks
    PaymentPresenter paymentPresenter;

    @Test
    public void getPaymentMethod() {
        paymentPresenter.getPaymentMethod("ammount");
        verify(paymentObserver).attachView(any(PaymentContract.View.class));
        verify(getPaymentUseCase).execute(any(PaymentObserver.class));
    }
}