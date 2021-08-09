package com.producto.demoProductos.producto.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoDto implements Serializable {

    private String nombre;
    private String precio;


}
