package com.anaistroncoso.paymentapp.presentation.payment;

import com.anaistroncoso.paymentapp.common.view.adapter.RenderRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class PaymentRender implements
        RenderRecyclerViewItem<PaymentViewModel, PaymentHolder> {

    Picasso picasso;

    @Inject
    public PaymentRender(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void onRender(PaymentHolder holder, PaymentViewModel item, int position) {
        picasso.load(item.thumbnail).into(holder.ivPayment);
        holder.tvPayment.setText(item.name);
    }
}
