package com.producto.demoProductos.producto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id", unique = true)
    private int id;
    @Column(name = "pro_nombre", unique = true)
    private String nombre;
    @Column(name = "pro_precio", unique = true)
    private float precio;
}


