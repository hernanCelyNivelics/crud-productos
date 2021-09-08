package com.hcely.crudproductos.usuario.component;

import com.hcely.crudproductos.usuario.dto.UsuarioDto;
import com.hcely.crudproductos.usuario.model.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface UsuarioMapper {

    UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    Usuario dtoToModel(UsuarioDto usuarioDto);

    @InheritInverseConfiguration
    UsuarioDto modelToDto(Usuario usuario);

    List<UsuarioDto> listModeltoDto(List<Usuario> usuarioDto);

}
