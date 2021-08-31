package com.producto.demoProductos.producto.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductoDto implements Serializable {

    @NotBlank
    private String nombreProducto;

    @Digits(integer=8, fraction=2)
    @Positive
    private BigDecimal precioProducto;


}
