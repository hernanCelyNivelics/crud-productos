package com.producto.demoProductos.usuario.service;

import com.producto.demoProductos.usuario.dto.UsuarioDto;

import java.util.List;


public interface UsuarioService {

    UsuarioDto add(UsuarioDto usuarioDto);
    List<UsuarioDto> getAll();
    UsuarioDto getById(UsuarioDto usuarioDto);
    UsuarioDto getByNombre(UsuarioDto usuarioDto);
    UsuarioDto update(int id, UsuarioDto usuarioDto);
    void delete(int id);
}
