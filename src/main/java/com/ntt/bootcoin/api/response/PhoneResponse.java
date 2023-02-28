package com.ntt.bootcoin.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneResponse {
    private boolean respuesta;
    private String name;
    private long idAccount;
    private String state;
}
