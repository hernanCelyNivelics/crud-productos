package com.producto.demoProductos.producto.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password", unique = true)
    private String password;

}
