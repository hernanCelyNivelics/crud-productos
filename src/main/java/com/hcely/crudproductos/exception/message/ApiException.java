package com.hcely.crudproductos.exception.message;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;


}
