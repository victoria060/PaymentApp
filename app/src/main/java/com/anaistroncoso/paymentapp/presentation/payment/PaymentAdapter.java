package com.anaistroncoso.paymentapp.presentation.payment;


import android.view.View;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.adapter.BaseAdapter;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.adapter.RenderRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;
import com.squareup.picasso.Picasso;


public class PaymentAdapter extends BaseAdapter<PaymentViewModel, PaymentHolder> {

    private final Picasso picasso;
    private OnClickRecyclerViewItem onClickRecyclerViewItem;

    public PaymentAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    protected PaymentHolder getViewHolder(View view) {
        return new PaymentHolder(view);
    }

    @Override
    protected RenderRecyclerViewItem<PaymentViewModel, PaymentHolder> getRenderViewItem() {
        return new PaymentRender(picasso);
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