package com.producto.demoProductos.usuario.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UsuarioDto {

    private int id;

    @NotBlank
    @Email
    private String username;

    @Size(min = 8, max= 30)
    @NotBlank
    private String password;
}
