package com.ntt.bootcoin.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "DWTPAYMENT")
@AllArgsConstructor
@NoArgsConstructor
public class BootcoinPaymentEntity extends ReactivePanacheMongoEntity {

    private String paymentMethod;
    private String sourceAccount;
    private String operationDate;
    private String destinationAccount;
    private double amountpay;
    private int transactionNumber;
    private Object list;

    public BootcoinPaymentEntity(Object list) {
        this.list = list;
    }
}
