package com.ntt.bootcoin.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.ntt.bootcoin.api.response.PhoneResponse;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient
@Path("/phone")
public interface PhoneApi {

    @GET
    @Path("/{telephone}")
    public Uni<PhoneResponse> findByTelephone(@PathParam("telephone") String telephone);
}
