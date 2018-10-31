package com.anaistroncoso.paymentapp.common.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.anaistroncoso.paymentapp.R;


public class ConfirmationDialog {

    private final Context context;

    public ConfirmationDialog(Context context) {
        this.context = context;
    }

    public void ShowDialog(String ammount, String payment, String cardIssuer, String installment) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(String.format(context.getString(R.string.confirmation_dialog_text), ammount, payment, cardIssuer, installment));
        builder1.setCancelable(true);
        builder1.setNeutralButton(
                context.getText(R.string.accept),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
