package com.anaistroncoso.paymentapp.common.view.activity;

import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;

public interface AppNavigation {

    void cleanFragmentStack();

    void addFragment(BaseFragment nextStep);

    void replaceFragment(BaseFragment nextStep);

}
