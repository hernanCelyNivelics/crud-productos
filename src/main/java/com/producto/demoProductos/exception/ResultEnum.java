package com.producto.demoProductos.exception;

public enum ResultEnum {

    SUCCES(1000, "Solicitud exitosa"),
    PARAMETER_ERROR(1001, "¡El parámetro de solicitud es incorrecto!"),
    UNKNOWN_ERROR(9999, "¡Error desconocido!");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;

    }
}
