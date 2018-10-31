package com.anaistroncoso.paymentapp.common.view;

import android.text.Editable;
import android.widget.EditText;

import com.anaistroncoso.paymentapp.BaseTest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AmmountTextWatcherTest extends BaseTest {

    @Mock
    EditText edittextAmmount;

    @InjectMocks
    AmmountTextWatcher ammountTextWatcher;

    @Test
    public void onTextChanged_whenAmmountIsValid_returnNormalFlow() {
        Editable editable = mock(Editable.class);
        when(editable.toString()).thenReturn("100");
        when(edittextAmmount.getText()).thenReturn(editable);
        ammountTextWatcher.onTextChanged(null, 0, 0, 0);
        verify(edittextAmmount).removeTextChangedListener(any(AmmountTextWatcher.class));
        verify(edittextAmmount).setText("$100");
        verify(edittextAmmount).setSelection(anyInt());
        verify(edittextAmmount).addTextChangedListener(any(AmmountTextWatcher.class));
    }

}