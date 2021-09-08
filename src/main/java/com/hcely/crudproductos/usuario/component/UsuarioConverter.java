package com.hcely.crudproductos.usuario.component;

import com.hcely.crudproductos.usuario.dto.UsuarioDto;
import com.hcely.crudproductos.usuario.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper
public class UsuarioConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")

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
