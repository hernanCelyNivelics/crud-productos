package com.producto.demoProductos.producto.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public final String message;

}
