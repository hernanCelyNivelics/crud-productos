package com.hcely.crudproductos.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {

    private int id;

    @NotBlank
    @Email
    private String username;

    @Size(min = 8, max= 30)
    @NotBlank
    private String password;
}
