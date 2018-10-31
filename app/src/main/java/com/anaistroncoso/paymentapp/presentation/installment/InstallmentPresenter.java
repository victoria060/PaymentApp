package com.anaistroncoso.paymentapp.presentation.installment;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;
import com.anaistroncoso.paymentapp.domain.usecase.GetInstallmentUseCase;
import com.anaistroncoso.paymentapp.presentation.viewmodel.GetInstallmentsViewModel;

import javax.inject.Inject;

public class InstallmentPresenter extends BasePresenter<InstallmentContract.View> implements InstallmentContract.Presenter {

    private final GetInstallmentUseCase getInstallmentUseCase;
    private final InstallmentObserver installmentObserver;

    @Inject
    public InstallmentPresenter(GetInstallmentUseCase getInstallmentUseCase, InstallmentObserver installmentObserver) {
        this.getInstallmentUseCase = getInstallmentUseCase;
        this.installmentObserver = installmentObserver;
        registerUseCase(this.getInstallmentUseCase);
    }


    @Override
    public void getInstallments(String ammount, String issuerId, String paymentMethodId) {
        installmentObserver.attachView(getView());
        GetInstallmentsViewModel getInstallmentsViewModel = new GetInstallmentsViewModel();
        getInstallmentsViewModel.amount = ammount;
        getInstallmentsViewModel.issuerId = issuerId;
        getInstallmentsViewModel.paymentMethodId = paymentMethodId;
        getInstallmentUseCase.execute(installmentObserver, getInstallmentsViewModel);
    }
}
