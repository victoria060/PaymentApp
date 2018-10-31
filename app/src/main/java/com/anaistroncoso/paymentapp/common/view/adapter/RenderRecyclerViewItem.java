package com.anaistroncoso.paymentapp.common.view.adapter;

public interface RenderRecyclerViewItem<T, H> {
    void onRender(H holder, T item, int position);
}
