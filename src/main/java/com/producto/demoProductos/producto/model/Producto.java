package com.producto.demoProductos.producto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    long precio;
}
