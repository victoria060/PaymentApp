package com.anaistroncoso.paymentapp.common.view.adapter;

import android.view.View;

public interface OnClickRecyclerViewItem<T> {
    void onClickItem(View view, T item);
}
