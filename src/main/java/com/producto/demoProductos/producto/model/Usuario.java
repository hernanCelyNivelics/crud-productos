package com.producto.demoProductos.producto.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id", unique = true)
    private int id;
    @Column(name = "us_email", unique = true)
    private String email;
    @Column(name = "us_contraseña", unique = true)
    private String contraseña;

}
