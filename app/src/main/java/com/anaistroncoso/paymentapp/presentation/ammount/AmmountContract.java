package com.anaistroncoso.paymentapp.presentation.ammount;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;

public interface AmmountContract {

    interface View extends BasePresenter.View {
        void showEmptyWarning();

        void goNextStep(String ammount);
    }

    interface Presenter {
        void validateAmmount(String ammount);
    }
}
