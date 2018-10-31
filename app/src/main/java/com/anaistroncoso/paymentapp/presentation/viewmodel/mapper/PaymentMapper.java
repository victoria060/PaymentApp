package com.anaistroncoso.paymentapp.presentation.viewmodel.mapper;

import com.anaistroncoso.paymentapp.domain.model.CardNumberModel;
import com.anaistroncoso.paymentapp.domain.model.PaymentModel;
import com.anaistroncoso.paymentapp.domain.model.SettingModel;
import com.anaistroncoso.paymentapp.domain.model.mapper.Mapper;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardNumberViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.SettingViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PaymentMapper extends Mapper<PaymentViewModel, PaymentModel> {

    @Inject
    public PaymentMapper() {
    }

    @Override
    public PaymentModel map(PaymentViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PaymentViewModel reverseMap(PaymentModel value) {
        PaymentViewModel paymentViewModel = new PaymentViewModel();
        paymentViewModel.id = value.id;
        paymentViewModel.name = value.name;
        paymentViewModel.paymentTypeId = value.paymentTypeId;
        paymentViewModel.status = value.status;
        paymentViewModel.secureThumbnail = value.secureThumbnail;
        paymentViewModel.thumbnail = value.thumbnail;
        paymentViewModel.deferredCapture = value.deferredCapture;
        paymentViewModel.paymentSetting = reverseMapSetting(value.paymentSetting);
        paymentViewModel.minAllowedAmount = value.minAllowedAmount;
        paymentViewModel.maxAllowedAmount = value.maxAllowedAmount;
        paymentViewModel.accreditationTime = value.accreditationTime;
        return paymentViewModel;
    }

    public List<SettingViewModel> reverseMapSetting(List<SettingModel> paymentSetting) {
        List<SettingViewModel> settingViewModelList = new ArrayList<>();
        for (SettingModel settingModel : paymentSetting) {
            SettingViewModel settingViewModel = new SettingViewModel();
            settingViewModel.paymentCardNumber = reverseMapCardNumber(settingModel.paymentCardNumber);
            settingViewModelList.add(settingViewModel);
        }
        return settingViewModelList;
    }

    public CardNumberViewModel reverseMapCardNumber(CardNumberModel cardNumberModel) {
        CardNumberViewModel cardNumberViewModel = new CardNumberViewModel();
        cardNumberViewModel.length = cardNumberModel.length;
        cardNumberViewModel.validation = cardNumberModel.validation;
        return cardNumberViewModel;
    }
}
