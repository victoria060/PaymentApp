package com.anaistroncoso.paymentapp.presentation.cardissuers;

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
import com.anaistroncoso.paymentapp.presentation.installment.InstallmentFragment;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.anaistroncoso.paymentapp.AppConstant.AMMOUNT;
import static com.anaistroncoso.paymentapp.AppConstant.PAYMENT_METHOD_ID;
import static com.anaistroncoso.paymentapp.AppConstant.PAYMENT_METHOD_NAME;

public class CardIssuerFragment extends BaseFragment implements CardIssuerContract.View, OnClickRecyclerViewItem<CardIssuerViewModel> {

    @Inject
    CardIssuerPresenter presenter;
    @Inject
    CardIssuerAdapter adapter;

    @BindView(R.id.cl_detail_item_selected)
    View clDetailContinue;
    @BindView(R.id.tv_description_selected)
    TextView tvPaymentName;
    @BindView(R.id.recycler)
    RecyclerView rvPayment;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private AppNavigation appNavigation;
    private SucessfullPayment sucessfullPayment;

    private String ammount;
    private String paymentId;
    private String paymentName;
    private String cardIssuerId;
    private String cardIssuerName;


    public static CardIssuerFragment getInstance(String ammount, String paymentId, String paymentName) {
        Bundle bundle = new Bundle();
        bundle.putString(AMMOUNT, ammount);
        bundle.putString(PAYMENT_METHOD_ID, paymentId);
        bundle.putString(PAYMENT_METHOD_NAME, paymentName);
        CardIssuerFragment paymentFragment = new CardIssuerFragment();
        paymentFragment.setArguments(bundle);
        return paymentFragment;
    }

    @Override
    protected void onPrepareFragment(View view) {
        super.onPrepareFragment(view);
        if (getArguments() != null) {
            ammount = getArguments().getString(AMMOUNT);
            paymentId = getArguments().getString(PAYMENT_METHOD_ID);
            paymentName = getArguments().getString(PAYMENT_METHOD_NAME);
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.toolbar_select_bank));
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
        presenter.attachView(this);
        presenter.getCardIssuers(paymentId);
    }

    @Override
    protected void onInjection() {
        DaggerCardIssuerComponent
                .builder()
                .cardIssuerModule(new CardIssuerModule(getContext()))
                .build()
                .inject(this);
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
    public void onClickItem(View view, CardIssuerViewModel item) {
        clDetailContinue.setVisibility(View.VISIBLE);
        tvPaymentName.setText(item.name);
        this.cardIssuerId = item.id;
        this.cardIssuerName = item.name;
    }

    @OnClick(R.id.bt_continue)
    public void goNextStep() {

        InstallmentFragment installmentFragment = InstallmentFragment.getInstance(ammount, paymentId, paymentName, cardIssuerId, cardIssuerName);
        installmentFragment.setAppNavigation(appNavigation);
        installmentFragment.setSucessfullPayment(sucessfullPayment);
        appNavigation.replaceFragment(installmentFragment);
    }

    @Override
    public void showCardIssuers(List<CardIssuerViewModel> cardIssuerViewModel) {
        adapter.setItems(cardIssuerViewModel);
        adapter.setOnClickListener(this);
        rvPayment.setAdapter(adapter);
        rvPayment.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    @Override
    public void showEmptyCardIssuers() {
        Snackbar mySnackbar = Snackbar.make(getView(), R.string.empty_array, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.accept, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });
        mySnackbar.show();
    }

    public void setSucessfullPayment(SucessfullPayment sucessfullPayment) {
        this.sucessfullPayment = sucessfullPayment;
    }
}
