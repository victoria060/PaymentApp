package com.anaistroncoso.paymentapp.common;

public class AmmountFormatting {

    public static String getNumbersFromChileanPesos(String chileanPesosFormat){
        return  chileanPesosFormat.replaceAll("\\D+","");
    }
}
