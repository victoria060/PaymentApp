package com.anaistroncoso.paymentapp.data.entity;

import com.anaistroncoso.paymentapp.data.constant.PaymentConstant;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentEntity {

    @SerializedName(PaymentConstant.ID)
    public String id;

    @SerializedName(PaymentConstant.NAME)
    public String name;

    @SerializedName(PaymentConstant.PAYMENT_TYPE_ID)
    public String paymentTypeId;

    @SerializedName(PaymentConstant.STATUS)
    public String status;

    @SerializedName(PaymentConstant.SECURE_THUMBNAIL)
    public String secureThumbnail;

    @SerializedName(PaymentConstant.THUMBNAIL)
    public String thumbnail;

    @SerializedName(PaymentConstant.DEFERRED_CAPTURE)
    public String deferredCapture; //TODO: -> am i going to use it?

    @SerializedName(PaymentConstant.SETTINGS)
    public List<SettingEntity> paymentSetting;

    @SerializedName(PaymentConstant.MIN_ALLOWED_AMOUNT)
    public float minAllowedAmount;

    @SerializedName(PaymentConstant.MAX_ALLOWED_AMOUNT)
    public int maxAllowedAmount;

    @SerializedName(PaymentConstant.ACCREDITATION_TIME)
    public int accreditationTime;
}
