package com.producto.demoProductos.producto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "nombre", unique = true)
    private String nombre;


    @Digits(integer=8, fraction=2)
    @Positive
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
}


