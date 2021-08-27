package com.producto.demoProductos.producto.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)

public class CreadoException extends Exception{

    private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private String message;
    private String errors;

    public CreadoException(HttpStatus status, String message, String errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
