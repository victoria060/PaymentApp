package com.anaistroncoso.paymentapp.presentation.cardissuers;

import com.anaistroncoso.paymentapp.BaseTest;
import com.anaistroncoso.paymentapp.domain.model.CardIssuerModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.CardIssuerViewModel;
import com.anaistroncoso.paymentapp.presentation.viewmodel.mapper.CardIssuerMapper;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CardIssuerObserverTest extends BaseTest {

    @Mock
    CardIssuerFragment view;
    @Mock
    CardIssuerMapper cardIssuerMapper;
    @InjectMocks
    CardIssuerObserver cardIssuerObserver;

    @Override
    public void setUp() {
        super.setUp();
        cardIssuerObserver.attachView(view);
    }

    @Test
    public void onStart() {
        cardIssuerObserver.onStart();
        verify(view).showLoading();
    }

    @Test
    public void onComplete() {
        cardIssuerObserver.onComplete();
        verify(view).hideLoading();
    }

    @Test
    public void onNext_empty() {
        List<CardIssuerViewModel> CardIssuerViewModel = new ArrayList<>();
        when(cardIssuerMapper.reverseMap(any(List.class))).thenReturn(CardIssuerViewModel);
        List<CardIssuerModel> cardIssuerModel = mock(ArrayList.class);
        cardIssuerObserver.onNext(cardIssuerModel);
        verify(view).showEmptyCardIssuers();
    }

    @Test
    public void onNext_with_values() {
        List<CardIssuerViewModel> cardIssuerViewModel = new ArrayList<>();
        cardIssuerViewModel.add(new CardIssuerViewModel());
        when(cardIssuerMapper.reverseMap(any(List.class))).thenReturn(cardIssuerViewModel);
        List<CardIssuerModel> cardIssuerModel = mock(ArrayList.class);
        cardIssuerObserver.onNext(cardIssuerModel);
        verify(view).showCardIssuers(any(List.class));
    }

    @Test
    public void onError() {
        Throwable e = mock(Throwable.class);
        cardIssuerObserver.onError(e);
        verify(view).hideLoading();
        verify(view).showConnectionError();
    }
}