package com.anaistroncoso.paymentapp.presentation.payment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.activity.SucessfullPayment;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;
import com.anaistroncoso.paymentapp.presentation.cardissuers.CardIssuerFragment;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.anaistroncoso.paymentapp.AppConstant.AMMOUNT;

public class PaymentFragment extends BaseFragment implements PaymentContract.View, OnClickRecyclerViewItem<PaymentViewModel> {

    @Inject
    PaymentPresenter paymentPresenter;
    @Inject
    PaymentAdapter paymentAdapter;

    @BindView(R.id.cl_detail_item_selected)
    View clDetailContinue;
    @BindView(R.id.tv_description_selected)
    TextView tvPaymentName;
    @BindView(R.id.recycler)
    RecyclerView rvPayment;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    AppNavigation appNavigation;
    SucessfullPayment sucessfullPayment;
    String ammount;
    String paymentId;
    String paymentName;

    public static PaymentFragment getInstance(String ammount) {
        Bundle bundle = new Bundle();
        bundle.putString(AMMOUNT, ammount);
        PaymentFragment paymentFragment = new PaymentFragment();
        paymentFragment.setArguments(bundle);
        return paymentFragment;
    }

    @Override
    protected void onPrepareFragment(View view) {
        super.onPrepareFragment(view);
        if (getArguments() != null) {
            ammount = getArguments().getString(AMMOUNT);
        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.toolbar_select_payment));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    public void setAppNavigation(AppNavigation appNavigation) {
        this.appNavigation = appNavigation;
    }

    @Override
    protected void onPreparePresenter() {
        paymentPresenter.attachView(this);
        paymentPresenter.getPaymentMethod(ammount);
    }

    @Override
    protected void onInjection() {
        DaggerPaymentComponent
                .builder()
                .paymentModule(new PaymentModule(getContext()))
                .build()
                .inject(this);
    }

    @Override
    public void showPaymentMethod(List<PaymentViewModel> paymentViewModels) {
        paymentAdapter.setItems(paymentViewModels);
        paymentAdapter.setOnClickListener(this);
        rvPayment.setAdapter(paymentAdapter);
        rvPayment.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    @Override
    public void showEmptyPayment() {
        Snackbar mySnackbar = Snackbar.make(getView(), R.string.empty_array, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.accept, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });
        mySnackbar.show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showConnectionError() {
        Snackbar mySnackbar = Snackbar.make(getView(),
                R.string.conection_error, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }

    @Override
    public void onClickItem(View view, PaymentViewModel item) {
        clDetailContinue.setVisibility(View.VISIBLE);
        tvPaymentName.setText(item.name);
        this.paymentId = item.id;
        this.paymentName = item.name;
    }


    @OnClick(R.id.bt_continue)
    public void goNextStep() {
        CardIssuerFragment cardIssuerFragment = CardIssuerFragment.getInstance(ammount, paymentId, paymentName);
        cardIssuerFragment.setAppNavigation(appNavigation);
        cardIssuerFragment.setSucessfullPayment(sucessfullPayment);
        appNavigation.replaceFragment(cardIssuerFragment);
    }

    public void setSucessfullPayment(SucessfullPayment sucessfullPayment) {
        this.sucessfullPayment = sucessfullPayment;
    }
}
