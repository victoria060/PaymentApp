package com.anaistroncoso.paymentapp.presentation.cardissuers;


import android.view.View;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.adapter.BaseAdapter;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.adapter.RenderRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;
import com.squareup.picasso.Picasso;


public class CardIssuerAdapter extends BaseAdapter<CardIssuerViewModel, CardIssuerHolder> {

    private final Picasso picasso;
    private OnClickRecyclerViewItem onClickRecyclerViewItem;

    public CardIssuerAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    protected CardIssuerHolder getViewHolder(View view) {
        return new CardIssuerHolder(view);
    }

    @Override
    protected RenderRecyclerViewItem<CardIssuerViewModel, CardIssuerHolder> getRenderViewItem() {
        return new CardIssuerRender(picasso);
    }

    @Override
    protected OnClickRecyclerViewItem getItemListener() {
        return onClickRecyclerViewItem;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_payment;
    }

    public void setOnClickListener(OnClickRecyclerViewItem onClickRecyclerViewItem) {
        this.onClickRecyclerViewItem = onClickRecyclerViewItem;
    }
}