package com.anaistroncoso.paymentapp.domain.model.mapper;

import com.anaistroncoso.paymentapp.data.entity.InstallmentEntity;
import com.anaistroncoso.paymentapp.data.entity.PayerCostEntity;
import com.anaistroncoso.paymentapp.domain.model.InstallmentModel;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InstallmentMapperTest {

    @Test
    public void reverseMap(){
        InstallmentMapper installmentMapper= new InstallmentMapper();
        InstallmentEntity installmentEntity = new InstallmentEntity();

        List<PayerCostEntity> payerCostList = new ArrayList<>();
        PayerCostEntity payerCostEntity = new PayerCostEntity();
        payerCostEntity.recommendedMessage= "some message";
        payerCostList.add(payerCostEntity);
        installmentEntity.payerCost = payerCostList;


        InstallmentModel installmentModel=installmentMapper.reverseMap(installmentEntity);
        Assert.assertEquals("some message", installmentModel.payerCost.get(0));
    }
}