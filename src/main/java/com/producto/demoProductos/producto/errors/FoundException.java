package com.producto.demoProductos.producto.errors;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;


@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class FoundException extends Exception{
    private HttpStatus status;
    private String message;
    private String errors;

    public FoundException(HttpStatus status, String message, String errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
