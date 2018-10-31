package com.anaistroncoso.paymentapp.domain.model.mapper;

import com.anaistroncoso.paymentapp.data.entity.CardNumberEntity;
import com.anaistroncoso.paymentapp.data.entity.PaymentEntity;
import com.anaistroncoso.paymentapp.data.entity.SettingEntity;
import com.anaistroncoso.paymentapp.domain.model.CardNumberModel;
import com.anaistroncoso.paymentapp.domain.model.PaymentModel;
import com.anaistroncoso.paymentapp.domain.model.SettingModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PaymentMapper extends Mapper<PaymentModel, PaymentEntity> {

    @Inject
    PaymentMapper() {

    }

    @Override
    public PaymentEntity map(PaymentModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PaymentModel reverseMap(PaymentEntity value) {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.id = value.id;
        paymentModel.name = value.name;
        paymentModel.paymentTypeId = value.paymentTypeId;
        paymentModel.status = value.status;
        paymentModel.secureThumbnail = value.secureThumbnail;
        paymentModel.thumbnail = value.thumbnail;
        paymentModel.deferredCapture = value.deferredCapture;
        paymentModel.paymentSetting = reverseMapSetting(value.paymentSetting);
        paymentModel.minAllowedAmount = value.minAllowedAmount;
        paymentModel.maxAllowedAmount = value.maxAllowedAmount;
        paymentModel.accreditationTime = value.accreditationTime;
        return paymentModel;
    }


    public List<SettingModel> reverseMapSetting(List<SettingEntity> paymentSetting) {
        List<SettingModel> settingModelList = new ArrayList<>();
        for (SettingEntity settingEntity : paymentSetting) {
            SettingModel settingModel = new SettingModel();
            settingModel.paymentCardNumber = reverseMapCardNumber(settingEntity.paymentCardNumber);
            settingModelList.add(settingModel);
        }
        return settingModelList;
    }

    public CardNumberModel reverseMapCardNumber(CardNumberEntity cardNumberEntity) {
        CardNumberModel cardNumberModel = new CardNumberModel();
        cardNumberModel.length = cardNumberEntity.length;
        cardNumberModel.validation = cardNumberEntity.validation;
        return cardNumberModel;
    }
}
