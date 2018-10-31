package com.anaistroncoso.paymentapp.presentation.payment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.RobolectricBaseTest;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PaymentViewModel;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaymentFragmentTest extends RobolectricBaseTest {


    @Mock
    View clDetailContinue;
    @Mock
    TextView tvPaymentName;
    @Mock
    RecyclerView rvPayment;
    @Mock
    ProgressBar progressBar;
    @Mock
    PaymentPresenter paymentPresenter;
    @Mock
    PaymentAdapter paymentAdapter;
    @InjectMocks
    PaymentFragment paymentFragment;


    @Test
    public void getLayoutId() {
        Assert.assertEquals(R.layout.fragment_recycler, paymentFragment.getLayoutId());
    }

    @Test
    public void setAppNavigation() {
        AppNavigation appNavigation = mock(AppNavigation.class);
        paymentFragment.setAppNavigation(appNavigation);
        Assert.assertEquals(appNavigation, paymentFragment.appNavigation);
    }

    @Test
    public void onPreparePresenter() {
        paymentFragment.onPreparePresenter();
        verify(paymentPresenter).attachView(any(PaymentContract.View.class));
        verify(paymentPresenter).getPaymentMethod(null);
    }

    @Test
    public void showPaymentMethod() {
        ArrayList<PaymentViewModel> paymentViewModels = mock(ArrayList.class);
        paymentFragment.showPaymentMethod(paymentViewModels);

        verify(paymentAdapter).setItems(paymentViewModels);
        verify(paymentAdapter).setOnClickListener(any(OnClickRecyclerViewItem.class));
        verify(rvPayment).setAdapter(paymentAdapter);
        verify(rvPayment).setLayoutManager(any(RecyclerView.LayoutManager.class));
    }

    @Test
    public void showLoading() {
        paymentFragment.showLoading();
        verify(progressBar).setVisibility(View.VISIBLE);
    }


    @Test
    public void hideLoading() {
        paymentFragment.hideLoading();
        verify(progressBar).setVisibility(View.GONE);
    }
    @Test public void onClickItem(){

    }


}