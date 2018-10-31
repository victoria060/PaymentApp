package com.anaistroncoso.paymentapp.domain.model;

import java.util.List;

public class PaymentModel {
    public String id;
    public String name;
    public String paymentTypeId;
    public String status;
    public String secureThumbnail;
    public String thumbnail;
    public String deferredCapture;
    public List<SettingModel> paymentSetting;
    public float minAllowedAmount;
    public int maxAllowedAmount;
    public int accreditationTime;
}
