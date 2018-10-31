package com.anaistroncoso.paymentapp.presentation.ammount;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.RobolectricBaseTest;
import com.anaistroncoso.paymentapp.common.view.AmmountTextWatcher;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.activity.SucessfullPayment;
import com.anaistroncoso.paymentapp.presentation.payment.PaymentFragment;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

public class AmmountFragmentTest extends RobolectricBaseTest {

    @Mock
    AmmountTextWatcher ammountTextWatcher;
    @Mock
    AmmountPresenter ammountPresenter;
    @Mock
    TextInputLayout inputLayoutAmmount;
    @Mock
    EditText edittextAmmount;
    @Mock
    AppNavigation appNavigation;
    @Mock
    SucessfullPayment sucessfullPayment;

    @InjectMocks
    AmmountFragment ammountFragment;

    @Test
    public void onPreparePresenter() {
        ammountFragment.onPreparePresenter();
        verify(ammountPresenter).attachView(any(AmmountContract.View.class));
    }

    @Test
    public void onPrepareFragment() {
        startFragment(ammountFragment, AppCompatActivity.class);
        ammountFragment.ammountTextWatcher = ammountTextWatcher;
        ammountFragment.edittextAmmount = edittextAmmount;
        ammountFragment.onPrepareFragment(ammountFragment.getView());

        verify(ammountTextWatcher).setEdittextAmmount(any(EditText.class));
        verify(edittextAmmount).addTextChangedListener(any(AmmountTextWatcher.class));

    }

    @Test
    public void getLayoutId() {
        Assert.assertEquals(R.layout.fragment_ammount, ammountFragment.getLayoutId());
    }

    @Test
    public void onContinueButtonClick() {
        startFragment(ammountFragment, AppCompatActivity.class);
        ammountFragment.inputLayoutAmmount = inputLayoutAmmount;
        ammountFragment.ammountPresenter = ammountPresenter;
        ammountFragment.onContinueButtonClick();
        verify(inputLayoutAmmount).setError(null);
        verify(ammountPresenter).validateAmmount(anyString());
    }

    @Test
    public void onShowEmptyWarning() {
        startFragment(ammountFragment, AppCompatActivity.class);
        ammountFragment.inputLayoutAmmount = inputLayoutAmmount;
        ammountFragment.showEmptyWarning();
        verify(inputLayoutAmmount).setError(anyString());
    }

    @Test
    public void goNextStep() {
        ammountFragment.goNextStep("ammount");
        verify(appNavigation).replaceFragment(any(PaymentFragment.class));
    }

    @Test
    public void setAppNavigation() {
        AppNavigation appNavigation = mock(AppNavigation.class);
        ammountFragment.setAppNavigation(appNavigation);
        Assert.assertEquals(appNavigation, ammountFragment.appNavigation);
    }

    @Test
    public void setSucessfullPayment() {
        SucessfullPayment sucessfullPayment = mock(SucessfullPayment.class);
        ammountFragment.setSucessfullPayment(sucessfullPayment);
        Assert.assertEquals(sucessfullPayment, ammountFragment.sucessfullPayment);
    }
}