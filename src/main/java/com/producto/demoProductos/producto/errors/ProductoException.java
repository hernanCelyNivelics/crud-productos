package com.producto.demoProductos.producto.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductoException extends Exception {

    private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private String message;
    private String errors;


}
