package com.producto.demoProductos.producto.domain.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UsuarioDto {

    @NotBlank//(message = "El usuario no puede estar vacio")
    private String username;

    @NotBlank
    @Size(min = 8, max= 30)
    private String password;
}
