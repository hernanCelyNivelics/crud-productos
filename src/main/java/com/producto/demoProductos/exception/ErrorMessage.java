package com.producto.demoProductos.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorMessage {

    public ErrorMessage(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;
}
