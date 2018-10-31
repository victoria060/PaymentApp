package com.anaistroncoso.paymentapp.presentation.installment;

import com.anaistroncoso.paymentapp.common.view.adapter.RenderRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PayerCostViewModel;

import javax.inject.Inject;

public class InstallmentRender implements
        RenderRecyclerViewItem<PayerCostViewModel, InstallmentHolder> {

    @Inject
    public InstallmentRender() {
    }

    @Override
    public void onRender(InstallmentHolder holder, PayerCostViewModel item, int position) {
        holder.tvDescription.setText(item.recommendedMessage);
    }


}
