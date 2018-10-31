package com.anaistroncoso.paymentapp.presentation.installment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.activity.SucessfullPayment;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PayerCostViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.anaistroncoso.paymentapp.AppConstant.AMMOUNT;
import static com.anaistroncoso.paymentapp.AppConstant.PAYMENT_CARD_ISSUER_ID;
import static com.anaistroncoso.paymentapp.AppConstant.PAYMENT_CARD_ISSUER_NAME;
import static com.anaistroncoso.paymentapp.AppConstant.PAYMENT_METHOD_ID;
import static com.anaistroncoso.paymentapp.AppConstant.PAYMENT_METHOD_NAME;

public class InstallmentFragment extends BaseFragment implements InstallmentContract.View, OnClickRecyclerViewItem<PayerCostViewModel> {

    @Inject
    InstallmentPresenter presenter;
    @Inject
    InstallmentAdapter adapter;

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
    String cardIssuerID;
    String installments;
    String cardIssuerName;

    public static InstallmentFragment getInstance(String ammount, String paymentId, String paymentName, String cardIssuerID, String cardIssuerName) {
        Bundle bundle = new Bundle();
        bundle.putString(AMMOUNT, ammount);
        bundle.putString(PAYMENT_METHOD_ID, paymentId);
        bundle.putString(PAYMENT_METHOD_NAME, paymentName);
        bundle.putString(PAYMENT_CARD_ISSUER_ID, cardIssuerID);
        bundle.putString(PAYMENT_CARD_ISSUER_NAME, cardIssuerName);
        InstallmentFragment paymentFragment = new InstallmentFragment();
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
            cardIssuerID = getArguments().getString(PAYMENT_CARD_ISSUER_ID);
            cardIssuerName = getArguments().getString(PAYMENT_CARD_ISSUER_NAME);
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.toolbar_select_installments));
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
        presenter.getInstallments(ammount, cardIssuerID, paymentId);
    }

    @Override
    protected void onInjection() {
        DaggerInstallmentComponent
                .builder()
                .installmentModule(new InstallmentModule(getContext()))
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
    public void onClickItem(View view, PayerCostViewModel item) {
        clDetailContinue.setVisibility(View.VISIBLE);
        tvPaymentName.setText(item.recommendedMessage);
        this.installments = item.recommendedMessage;
    }

    @OnClick(R.id.bt_continue)
    public void goNextStep() {
        appNavigation.cleanFragmentStack();
        sucessfullPayment.showDialogData(ammount, paymentName, cardIssuerName, installments);
    }

    @Override
    public void showInstallments(List<PayerCostViewModel> payerCostViewModel) {
        adapter.setItems(payerCostViewModel);
        adapter.setOnClickListener(this);
        rvPayment.setAdapter(adapter);
        rvPayment.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showEmptyInstallments() {
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
