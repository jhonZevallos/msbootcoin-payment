package com.ntt.bootcoin.service;

import com.ntt.bootcoin.entity.BootcoinPaymentEntity;

import io.smallrye.mutiny.Uni;

public interface PaymentService {

    public Uni<BootcoinPaymentEntity> getPaymentMethod(String paymentMethod, String sourceAccount);

    public Uni<BootcoinPaymentEntity> addPay(BootcoinPaymentEntity bootcoinPaymentEntity);
}
