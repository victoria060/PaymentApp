package com.anaistroncoso.paymentapp.presentation.payment;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.domain.model.PaymentModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.PaymentMapper;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PaymentObserverTest extends BaseTest {

    @Mock
    PaymentFragment view;
    @Mock
    PaymentMapper paymentMapper;
    @InjectMocks
    PaymentObserver paymentObserver;

    @Override
    public void setUp() {
        super.setUp();
        paymentObserver.attachView(view);
    }

    @Test
    public void onStart() {
        paymentObserver.onStart();
        verify(view).showLoading();
    }

    @Test
    public void onComplete() {
        paymentObserver.onComplete();
        verify(view).hideLoading();
    }

    @Test
    public void onNext_empty() {
        List<PaymentViewModel> paymentViewModel = new ArrayList<>();
        when(paymentMapper.reverseMap(any(List.class))).thenReturn(paymentViewModel);
        List<PaymentModel> paymentModel = mock(ArrayList.class);
        paymentObserver.onNext(paymentModel);
        verify(view).showEmptyPayment();
    }

    @Test
    public void onNext_with_values() {
        List<PaymentViewModel> paymentViewModel = new ArrayList<>();
        paymentViewModel.add(new PaymentViewModel());
        when(paymentMapper.reverseMap(any(List.class))).thenReturn(paymentViewModel);
        List<PaymentModel> paymentModel = mock(ArrayList.class);
        paymentObserver.onNext(paymentModel);
        verify(view).showPaymentMethod(any(List.class));
    }

    @Test
    public void onError() {
        Throwable e = mock(Throwable.class);
        paymentObserver.onError(e);
        verify(view).hideLoading();
        verify(view).showConnectionError();
    }
}