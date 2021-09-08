package com.hcely.crudproductos.exception.message;

public class UsuarioExistException extends RuntimeException{

    public UsuarioExistException(String detail) {
        super(detail);
    }
}
