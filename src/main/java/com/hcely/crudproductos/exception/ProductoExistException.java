package com.hcely.crudproductos.exception;

public class ProductoExistException extends RuntimeException{

    public ProductoExistException(String detail) {
        super(detail);
    }


}
