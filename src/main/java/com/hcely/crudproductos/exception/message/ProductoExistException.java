package com.hcely.crudproductos.exception.message;

public class ProductoExistException extends RuntimeException{

    public ProductoExistException(String detail) {
        super(detail);
    }


}
