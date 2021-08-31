package com.producto.demoProductos.exception;

public class UsuarioExistException extends RuntimeException{

    public UsuarioExistException(String detail) {
        super(detail);
    }
}
