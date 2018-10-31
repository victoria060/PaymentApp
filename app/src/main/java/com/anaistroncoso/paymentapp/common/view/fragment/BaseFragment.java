package com.anaistroncoso.paymentapp.common.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        onBindViews(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onInjection();
        onPrepareFragment(view);
        onPreparePresenter();
    }

    protected void onPreparePresenter() {
    }

    protected void onPrepareFragment(View view) {
    }

    protected void onInjection() {
    }
    
    protected abstract int getLayoutId();

    protected void onBindViews(View view) {
        unbinder = ButterKnife.bind(this, view);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
