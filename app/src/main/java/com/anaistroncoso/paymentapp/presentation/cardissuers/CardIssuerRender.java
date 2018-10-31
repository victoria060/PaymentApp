package com.anaistroncoso.paymentapp.presentation.cardissuers;

import com.anaistroncoso.paymentapp.common.view.adapter.RenderRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class CardIssuerRender implements
        RenderRecyclerViewItem<CardIssuerViewModel, CardIssuerHolder> {

    Picasso picasso;

    @Inject
    public CardIssuerRender(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void onRender(CardIssuerHolder holder, CardIssuerViewModel item, int position) {
        picasso.load(item.thumbnail).into(holder.ivPayment);
        holder.tvPayment.setText(item.name);
    }
}
