package com.anaistroncoso.paymentapp.presentation.viewmodel;

import java.util.List;

public class PaymentViewModel {
    public String id;
    public String name;
    public String paymentTypeId;
    public String status;
    public String secureThumbnail;
    public String thumbnail;
    public String deferredCapture;
    public List<SettingViewModel> paymentSetting;
    public float minAllowedAmount;
    public int maxAllowedAmount;
    public int accreditationTime;
}
