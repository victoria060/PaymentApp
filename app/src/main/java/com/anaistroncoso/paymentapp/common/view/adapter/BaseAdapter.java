package com.anaistroncoso.paymentapp.common.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T, H extends BaseViewHolder> extends RecyclerView.Adapter<H> {

    protected List<T> items;


    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(H holder, final int position) {
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItemListener() != null && items != null && !items.isEmpty()) {
                    getItemListener().onClickItem(v, items.get(position));
                }
            }
        });
        getRenderViewItem().onRender(holder, items.get(position), position);
    }


    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract H getViewHolder(View view);

    protected abstract RenderRecyclerViewItem<T, H> getRenderViewItem();

    protected abstract OnClickRecyclerViewItem getItemListener();

    protected abstract int getLayoutId();
}
