package com.anaistroncoso.paymentapp.presentation.installment;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.domain.model.InstallmentModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.InstallmentViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.InstallmentMapper;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InstallmentObserverTest extends BaseTest {

    @Mock
    InstallmentFragment view;
    @Mock
    InstallmentMapper installmentMapper;
    @InjectMocks
    InstallmentObserver installmentObserver;

    @Override
    public void setUp() {
        super.setUp();
        installmentObserver.attachView(view);
    }

    @Test
    public void onStart() {
        installmentObserver.onStart();
        verify(view).showLoading();
    }

    @Test
    public void onComplete() {
        installmentObserver.onComplete();
        verify(view).hideLoading();
    }

    @Test
    public void onNext_empty() {
        List<InstallmentViewModel> installmentViewModel = new ArrayList<>();
        when(installmentMapper.reverseMap(any(List.class))).thenReturn(installmentViewModel);
        List<InstallmentModel> installmentModel = mock(ArrayList.class);
        installmentObserver.onNext(installmentModel);
        verify(view).showEmptyInstallments();
    }

    @Test
    public void onNext_with_values() {
        List<InstallmentViewModel> installmentViewModels = new ArrayList<>();
        InstallmentViewModel installmentViewModel = new InstallmentViewModel();
        installmentViewModel.payerCost = mock(List.class);
        installmentViewModels.add(installmentViewModel);
        when(installmentMapper.reverseMap(any(List.class))).thenReturn(installmentViewModels);
        List<InstallmentModel> installmentModel = mock(ArrayList.class);
        installmentObserver.onNext(installmentModel);
        verify(view).showInstallments(any(List.class));
    }

    @Test
    public void onError() {
        Throwable e = mock(Throwable.class);
        installmentObserver.onError(e);
        verify(view).hideLoading();
        verify(view).showConnectionError();
    }
}