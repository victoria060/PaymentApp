package com.anaistroncoso.paymentapp.presentation.installment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.RobolectricBaseTest;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;
import com.anaistroncoso.paymentapp.presentation.viewmodel.PayerCostViewModel;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InstallmentFragmentTest extends RobolectricBaseTest {

    @Mock
    View clDetailContinue;
    @Mock
    TextView tvInstallmentName;
    @Mock
    RecyclerView rvInstallment;
    @Mock
    ProgressBar progressBar;
    @Mock
    InstallmentPresenter installmentPresenter;
    @Mock
    InstallmentAdapter installmentAdapter;
    @Mock
    AppNavigation appNavigation;
    @InjectMocks
    InstallmentFragment installmentFragment;


    @Test
    public void getLayoutId() {
        Assert.assertEquals(R.layout.fragment_recycler, installmentFragment.getLayoutId());
    }

    @Test
    public void setAppNavigation() {
        AppNavigation appNavigation = mock(AppNavigation.class);
        installmentFragment.setAppNavigation(appNavigation);
        Assert.assertEquals(appNavigation, installmentFragment.appNavigation);
    }

    @Test
    public void onPreparePresenter() {
        installmentFragment.onPreparePresenter();
        verify(installmentPresenter).attachView(any(InstallmentContract.View.class));
        verify(installmentPresenter).getInstallments(null, null, null);
    }

    @Test
    public void showInstallmentMethod() {
        ArrayList<PayerCostViewModel> PayerCostViewModels = mock(ArrayList.class);
        installmentFragment.showInstallments(PayerCostViewModels);

        verify(installmentAdapter).setItems(PayerCostViewModels);
        verify(installmentAdapter).setOnClickListener(any(OnClickRecyclerViewItem.class));
        verify(rvInstallment).setAdapter(installmentAdapter);
        verify(rvInstallment).setLayoutManager(any(RecyclerView.LayoutManager.class));
    }

    @Test
    public void showLoading() {
        installmentFragment.showLoading();
        verify(progressBar).setVisibility(View.VISIBLE);
    }


    @Test
    public void hideLoading() {
        installmentFragment.hideLoading();
        verify(progressBar).setVisibility(View.GONE);
    }

    @Test
    public void onClickItem() {
        View view = mock(View.class);
        PayerCostViewModel payerCostViewModel = mock(PayerCostViewModel.class);
        installmentFragment.onClickItem(view, payerCostViewModel);
        verify(clDetailContinue).setVisibility(View.VISIBLE);
        verify(tvInstallmentName).setText(null);
    }

    public void goNextStep() {
        installmentFragment.goNextStep();
        verify(appNavigation).replaceFragment(any(BaseFragment.class));

    }

}