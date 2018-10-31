package com.anaistroncoso.paymentapp.common.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    View view;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.view = itemView;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
    }

    public int getViewHolderType() {
        return getItemViewType();
    }

}
