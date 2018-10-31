package com.anaistroncoso.paymentapp.presentation.ammount;

import com.anaistroncoso.paymentapp.BaseTest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class AmmountPresenterTest extends BaseTest {

    @Mock
    AmmountContract.View view;
    @InjectMocks
    AmmountPresenter ammountPresenter;

    @Test
    public void validateAmmount_whenAmmountIsNull_returnshowEmptyWarning() {
        ammountPresenter.validateAmmount("");
        verify(view).showEmptyWarning();
    }

    @Test
    public void validateAmmount_whenAmmountValid_returnGoNextStep() {
        ammountPresenter.validateAmmount("ammount");
        verify(view).goNextStep("ammount");
    }

}