package com.anaistroncoso.paymentapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.anaistroncoso.paymentapp.common.view.ConfirmationDialog;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.activity.BaseActivity;
import com.anaistroncoso.paymentapp.common.view.activity.SucessfullPayment;
import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;
import com.anaistroncoso.paymentapp.presentation.ammount.AmmountFragment;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements AppNavigation,SucessfullPayment {

    private static final String TRANSACTION = "myPopTransaction";

    @BindView(R.id.my_toolbar)
    Toolbar toolbar;

    AmmountFragment ammountFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public int getContainerViewId() {
        return R.id.main_content;
    }

    @Override
    protected void onPrepareActivity() {
        super.onPrepareActivity();
        setSupportActionBar(toolbar);
        ammountFragment = new AmmountFragment();
        ammountFragment.setAppNavigation(this);
        ammountFragment.setSucessfullPayment(this);
        addFragment(ammountFragment);
    }

    @Override
    public void showDialogData(String ammount, String payment, String cardIssuer, String installment) {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog(this);
        confirmationDialog.ShowDialog(ammount, payment, cardIssuer, installment);
    }

    @Override
    public void cleanFragmentStack() {
        getSupportFragmentManager().popBackStack(TRANSACTION, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void addFragment(BaseFragment baseFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(getContainerViewId(), baseFragment).commit();
    }

    @Override
    public void replaceFragment(BaseFragment baseFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getContainerViewId(), baseFragment, baseFragment.getTag()).addToBackStack(TRANSACTION).commit();
    }

}
