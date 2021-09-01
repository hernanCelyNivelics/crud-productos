package com.hcely.crudproductos.exception;

public class UsuarioExistException extends RuntimeException{

    public UsuarioExistException(String detail) {
        super(detail);
    }
}
