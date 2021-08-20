package com.producto.demoProductos.producto.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = true)

public class CreadoException extends Exception{

    private static final long serialVersionUID = 1L;
    public final String message;
    public final Throwable cause;
}
