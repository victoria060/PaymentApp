package com.anaistroncoso.paymentapp.presentation.installment;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PayerCostViewModel;

import java.util.List;

public interface InstallmentContract {

    interface View extends BasePresenter.View {
        void showInstallments(List<PayerCostViewModel> payerCostViewModel);

        void showEmptyInstallments();

    }

    interface Presenter {
        void getInstallments(String ammount, String issuerId, String paymentMethodId);
    }
}
