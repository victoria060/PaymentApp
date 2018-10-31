package com.anaistroncoso.paymentapp.presentation.payment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.adapter.BaseViewHolder;

import butterknife.BindView;

public class PaymentHolder extends BaseViewHolder {

    public @BindView(R.id.iv_payment)
    ImageView ivPayment;

    public @BindView(R.id.tv_payment)
    TextView tvPayment;


    public PaymentHolder(View itemView) {
        super(itemView);
    }
}
