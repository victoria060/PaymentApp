package com.anaistroncoso.paymentapp.presentation.ammount;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.common.view.AmmountTextWatcher;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.activity.SucessfullPayment;
import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;
import com.anaistroncoso.paymentapp.presentation.payment.PaymentFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.anaistroncoso.paymentapp.common.AmmountFormatting.getNumbersFromChileanPesos;


public class AmmountFragment extends BaseFragment implements AmmountContract.View {


    @Inject
    AmmountTextWatcher ammountTextWatcher;
    @Inject
    AmmountPresenter ammountPresenter;

    @BindView(R.id.textinputlayout_input_amount)
    TextInputLayout inputLayoutAmmount;
    @BindView(R.id.edittext_input_name)
    EditText edittextAmmount;

    AppNavigation appNavigation;
    SucessfullPayment sucessfullPayment;


    @Override
    protected void onPreparePresenter() {
        ammountPresenter.attachView(this);
    }

    @Override
    protected void onPrepareFragment(View view) {
        super.onPrepareFragment(view);
        ammountTextWatcher.setEdittextAmmount(edittextAmmount);
        edittextAmmount.addTextChangedListener(ammountTextWatcher);

        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.toolbar_enter_amount));
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ammount;
    }


    @OnClick(R.id.button_continue)
    void onContinueButtonClick() {
        inputLayoutAmmount.setError(null);
        ammountPresenter.validateAmmount(edittextAmmount.getText().toString());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showConnectionError() {
        Snackbar mySnackbar = Snackbar.make(getView(),
                R.string.conection_error, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }

    @Override
    public void showEmptyWarning() {
        inputLayoutAmmount.setError(getString(R.string.empty_value_warning));
    }

    @Override
    public void goNextStep(String ammount) {
        PaymentFragment paymentFragment = PaymentFragment.
                getInstance(getNumbersFromChileanPesos(ammount));
        paymentFragment.setAppNavigation(appNavigation);
        paymentFragment.setSucessfullPayment(sucessfullPayment);
        appNavigation.replaceFragment(paymentFragment);
    }

    @Override
    protected void onInjection() {
        DaggerAmmountComponent
                .builder()
                .build()
                .inject(this);
    }

    public void setAppNavigation(AppNavigation appNavigation) {
        this.appNavigation = appNavigation;
    }

    public void setSucessfullPayment(SucessfullPayment sucessfullPayment) {
        this.sucessfullPayment = sucessfullPayment;
    }
}
