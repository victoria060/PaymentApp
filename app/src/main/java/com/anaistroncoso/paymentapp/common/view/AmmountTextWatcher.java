package com.anaistroncoso.paymentapp.common.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.inject.Inject;

public class AmmountTextWatcher implements TextWatcher {

    EditText edittextAmmount;

    @Inject
    public AmmountTextWatcher() {

    }

    public void setEdittextAmmount(EditText edittextAmmount) {
        this.edittextAmmount = edittextAmmount;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String reading = edittextAmmount.getText().toString();
        reading = reading.replaceAll("[^$.0-9]", "");
        if (reading != null && !reading.isEmpty()) {
            edittextAmmount.removeTextChangedListener(this);
            reading = reading.replaceAll("[$,.]", "");
            edittextAmmount.setText("$" + formatChileanPesos(reading));
            edittextAmmount.setSelection(edittextAmmount.getText().length());
            edittextAmmount.addTextChangedListener(this);
        }
    }

    private String formatChileanPesos(String input) {
        if (!input.isEmpty()) {
            String number = input.replace(".", "");
            DecimalFormat df = new DecimalFormat("#,###", new DecimalFormatSymbols(new Locale("es", "CL")));
            return df.format(Long.parseLong(number));
        } else {
            return "";
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
