package com.producto.demoProductos.exception;

public class NoDataFoundException extends RuntimeException {

    private static final String message = "No se encontraron datos";

    public NoDataFoundException(String detail) {
        super(detail);
    }
}
