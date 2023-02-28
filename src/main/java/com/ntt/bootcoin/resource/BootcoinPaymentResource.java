package com.ntt.bootcoin.resource;

import com.ntt.bootcoin.entity.BootcoinPaymentEntity;
import com.ntt.bootcoin.service.PaymentService;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/paymentBootcoin")
public class BootcoinPaymentResource {
    @Inject
    PaymentService payservice;

    @Inject
    Logger logger;

    @GET
    @Path("/{paymentMethod}/{sourceAccount}")
    public Uni<BootcoinPaymentEntity> getPaymentsOperation(@PathParam("paymentMethod") String paymentMethod,
            @PathParam("sourceAccount") String sourceAccount) {
        logger.info("inciando el metodo getPaymentOperation - Resource");
        return payservice.getPaymentMethod(paymentMethod, sourceAccount);
    }

    @POST
    public Uni<BootcoinPaymentEntity> addPay(BootcoinPaymentEntity bootcoinPaymentEntity) {
        logger.info("Iniciando metodo addPayment - resource");
        return payservice.addPay(bootcoinPaymentEntity);
    }
}
