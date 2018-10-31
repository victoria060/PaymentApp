package com.anaistroncoso.paymentapp.presentation.installment;


import android.view.View;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.adapter.BaseAdapter;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.adapter.RenderRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PayerCostViewModel;


public class InstallmentAdapter extends BaseAdapter<PayerCostViewModel, InstallmentHolder> {

    private OnClickRecyclerViewItem onClickRecyclerViewItem;

    public InstallmentAdapter() {
    }

    @Override
    protected InstallmentHolder getViewHolder(View view) {
        return new InstallmentHolder(view);
    }

    @Override
    protected RenderRecyclerViewItem<PayerCostViewModel, InstallmentHolder> getRenderViewItem() {
        return new InstallmentRender();
    }

    @Override
    protected OnClickRecyclerViewItem getItemListener() {
        return onClickRecyclerViewItem;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_installment;
    }

    public void setOnClickListener(OnClickRecyclerViewItem onClickRecyclerViewItem) {
        this.onClickRecyclerViewItem = onClickRecyclerViewItem;
    }
}