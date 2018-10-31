package com.anaistroncoso.paymentapp.common;

import org.junit.Assert;
import org.junit.Test;

import static com.anaistroncoso.paymentapp.common.AmmountFormatting.getNumbersFromChileanPesos;

public class AmmountFormattingTest {

    @Test
    public void getNumbersFromChileanPesos_whenPesosAreValid_returnsOnlyNumber(){
        Assert.assertEquals("1", getNumbersFromChileanPesos("$1"));
    }
}