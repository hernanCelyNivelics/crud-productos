package com.producto.demoProductos.producto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "nombre", unique = true)
    private String nombre;
    @Column(name = "precio", unique = true)
    private float precio;
}


