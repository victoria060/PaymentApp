package com.anaistroncoso.paymentapp.presentation.installment;

import android.view.View;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.adapter.BaseViewHolder;

import butterknife.BindView;

public class InstallmentHolder extends BaseViewHolder {

    public @BindView(R.id.tv_description_detail)
    TextView tvDescription;

    public InstallmentHolder(View itemView) {
        super(itemView);
    }
}
