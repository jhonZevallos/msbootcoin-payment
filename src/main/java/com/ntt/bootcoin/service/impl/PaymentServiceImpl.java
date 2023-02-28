package com.ntt.bootcoin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.ntt.bootcoin.api.PhoneApi;
import com.ntt.bootcoin.api.response.PhoneResponse;
import com.ntt.bootcoin.entity.BootcoinPaymentEntity;
import com.ntt.bootcoin.service.PaymentService;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService {

    @RestClient
    PhoneApi phoneRest;

    @ConfigProperty(name = "mensaje.telefono_null")
    String messageNPhone;

    @Override
    public Uni<BootcoinPaymentEntity> addPay(BootcoinPaymentEntity bootcoinPaymentEntity) {
        Uni<PhoneResponse> phone = phoneRest.findByTelephone(bootcoinPaymentEntity.getSourceAccount());
        if (phone != null) {
            return bootcoinPaymentEntity.persist();

        }
        return null;
    }

    @Override
    public Uni<BootcoinPaymentEntity> getPaymentMethod(String paymentMethod, String sourceAccount) {
        Map<String, Object> params = new HashMap<>();
        params.put("paymentMethod", paymentMethod);
        params.put("sourceAccount", sourceAccount);

        Uni<List<BootcoinPaymentEntity>> listpay = BootcoinPaymentEntity
                .list("paymentMethod=:paymentMethod and sourceAccount=:sourceAccount", params);
        return listpay.map(resp -> {
            List<BootcoinPaymentEntity> list = new ArrayList<>();
            for (BootcoinPaymentEntity obj : resp) {
                list.add(obj);
            }
            return new BootcoinPaymentEntity(list);
        }).onFailure().recoverWithItem(ex -> new BootcoinPaymentEntity(ex.getMessage()));
    }

}
