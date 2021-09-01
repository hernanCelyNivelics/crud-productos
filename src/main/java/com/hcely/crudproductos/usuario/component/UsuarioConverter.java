package com.hcely.crudproductos.usuario.component;

import com.hcely.crudproductos.usuario.dto.UsuarioDto;
import com.hcely.crudproductos.usuario.model.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    public UsuarioDto modelToDto(Usuario usuario) {
        var usuarioDto = new UsuarioDto();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return usuarioDto;
    }

    public List<UsuarioDto> listModelToDto(List<Usuario> usuarios) {

        List<UsuarioDto> usuariosDto = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosDto.add(modelToDto(usuario));
        }
        return usuariosDto;
    }

    public Usuario dtoToModel(UsuarioDto usuarioDto) {
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return usuario;
    }
}
