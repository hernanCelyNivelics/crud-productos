package com.hcely.crudproductos.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String detail) {
        super(detail);
    }
}
