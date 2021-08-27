package com.producto.demoProductos.producto.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductoDto implements Serializable {

    @NotBlank
    private String nombre;

    @Digits(integer=8, fraction=2)
    @Positive
    private BigDecimal precio;


}
