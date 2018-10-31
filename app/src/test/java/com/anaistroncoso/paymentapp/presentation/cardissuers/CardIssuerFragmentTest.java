package com.anaistroncoso.paymentapp.presentation.cardissuers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anaistroncoso.paymentapp.R;
import com.anaistroncoso.paymentapp.RobolectricBaseTest;
import com.anaistroncoso.paymentapp.common.view.activity.AppNavigation;
import com.anaistroncoso.paymentapp.common.view.adapter.OnClickRecyclerViewItem;
import com.anaistroncoso.paymentapp.common.view.fragment.BaseFragment;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CardIssuerFragmentTest extends RobolectricBaseTest {
    
    @Mock
    View clDetailContinue;
    @Mock
    TextView tvCardIssuerName;
    @Mock
    RecyclerView rvCardIssuer;
    @Mock
    ProgressBar progressBar;
    @Mock
    CardIssuerPresenter cardIssuerPresenter;
    @Mock
    CardIssuerAdapter cardIssuerAdapter;
    @Mock
    AppNavigation appNavigation;
    @InjectMocks
    CardIssuerFragment cardIssuerFragment;


    @Test
    public void getLayoutId() {
        Assert.assertEquals(R.layout.fragment_recycler, cardIssuerFragment.getLayoutId());
    }

    @Test
    public void setAppNavigation() {
        AppNavigation appNavigation = mock(AppNavigation.class);
        cardIssuerFragment.setAppNavigation(appNavigation);
        Assert.assertEquals(appNavigation, cardIssuerFragment.appNavigation);
    }

    @Test
    public void onPreparePresenter() {
        cardIssuerFragment.onPreparePresenter();
        verify(cardIssuerPresenter).attachView(any(CardIssuerContract.View.class));
        verify(cardIssuerPresenter).getCardIssuers(null);
    }

    @Test
    public void showCardIssuerMethod() {
        ArrayList<CardIssuerViewModel> CardIssuerViewModels = mock(ArrayList.class);
        cardIssuerFragment.showCardIssuers(CardIssuerViewModels);

        verify(cardIssuerAdapter).setItems(CardIssuerViewModels);
        verify(cardIssuerAdapter).setOnClickListener(any(OnClickRecyclerViewItem.class));
        verify(rvCardIssuer).setAdapter(cardIssuerAdapter);
        verify(rvCardIssuer).setLayoutManager(any(RecyclerView.LayoutManager.class));
    }

    @Test
    public void showLoading() {
        cardIssuerFragment.showLoading();
        verify(progressBar).setVisibility(View.VISIBLE);
    }


    @Test
    public void hideLoading() {
        cardIssuerFragment.hideLoading();
        verify(progressBar).setVisibility(View.GONE);
    }

    @Test
    public void onClickItem() {
        View view = mock(View.class);
        CardIssuerViewModel cardIssuerModel = mock(CardIssuerViewModel.class);
        cardIssuerFragment.onClickItem(view, cardIssuerModel);
        verify(clDetailContinue).setVisibility(View.VISIBLE);
        verify(tvCardIssuerName).setText(null);
    }

    public void goNextStep() {
        cardIssuerFragment.goNextStep();
        verify(appNavigation).replaceFragment(any(BaseFragment.class));

    }

}