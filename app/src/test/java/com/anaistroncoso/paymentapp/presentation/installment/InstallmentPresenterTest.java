package com.anaistroncoso.paymentapp.presentation.installment;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.domain.usecase.GetInstallmentUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.GetInstallmentsViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.InstallmentMapper;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class InstallmentPresenterTest extends BaseTest {

    @Mock
    InstallmentMapper installmentMapper;
    @Mock
    GetInstallmentUseCase getInstallmentUseCase;
    @Mock
    InstallmentObserver installmentObserver;
    @Mock
    InstallmentContract.View view;
    @InjectMocks
    InstallmentPresenter installmentPresenter;


    @Test
    public void getInstallmentMethod() {
        installmentPresenter.getInstallments("ammount", "issuerID", "paymentMathodId");
        verify(installmentObserver).attachView(any(InstallmentContract.View.class));
        verify(getInstallmentUseCase).execute(any(InstallmentObserver.class), any(GetInstallmentsViewModel.class));
    }

}