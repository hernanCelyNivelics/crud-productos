package com.hcely.crudproductos.exception.message;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String detail) {
        super(detail);
    }
}
