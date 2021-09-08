package com.hcely.crudproductos.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequestDto {

    private String username;
    private String password;
}
