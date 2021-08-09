package com.producto.demoProductos.producto.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UsuarioDto {

    private String username;

    private String password;
}
