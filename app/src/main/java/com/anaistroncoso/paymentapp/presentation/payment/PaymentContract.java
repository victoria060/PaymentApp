package com.anaistroncoso.paymentapp.presentation.payment;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;

import java.util.List;

public interface PaymentContract {

    interface View extends BasePresenter.View {
        void showPaymentMethod(List<PaymentViewModel> paymentViewModel);

        void showEmptyPayment();
    }

    interface Presenter {
        void getPaymentMethod(String ammount);
    }
}
