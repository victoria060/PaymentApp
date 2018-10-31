package com.anaistroncoso.paymentapp.presentation.ammount;

import com.anaistroncoso.paymentapp.common.presenter.BasePresenter;

import javax.inject.Inject;

public class AmmountPresenter extends BasePresenter<AmmountContract.View> implements AmmountContract.Presenter {

    @Inject
    public AmmountPresenter() {
    }

    @Override
    public void validateAmmount(String ammount) {
        if (ammount == null || ammount.isEmpty()) {
            getView().showEmptyWarning();
        } else {
            getView().goNextStep(ammount);
        }
    }
}
