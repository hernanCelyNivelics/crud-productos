package com.producto.demoProductos.producto.persistence.model;


import lombok.Data;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Email
    @Column(name = "username", unique = true)
    private String username;

    @Size(min = 8, max= 30)
    @NotBlank
    @Column(name = "password", unique = true)
    private String password;

}
