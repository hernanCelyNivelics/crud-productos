package com.producto.demoProductos.usuario.service.impl;

import com.producto.demoProductos.exception.NoDataFoundException;
import com.producto.demoProductos.usuario.component.UsuarioConverter;
import com.producto.demoProductos.usuario.dto.UsuarioDto;
import com.producto.demoProductos.usuario.repo.UsuarioRepository;
import com.producto.demoProductos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Override
    public UsuarioDto add(UsuarioDto usuarioDto) {
        var usuario = usuarioConverter.dtoToModel(usuarioDto);
        return usuarioConverter.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto getByNombre(UsuarioDto usuarioDto) {
        var usuario = usuarioConverter.dtoToModel(usuarioDto);
        var usuarioBuscado=usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioBuscado == null){
            throw new NoDataFoundException("El usuario "+usuarioDto.getUsername()+" no se encontro");
        }
        return usuarioConverter.modelToDto(usuarioRepository.findByUsername(usuario.getUsername()));
    }

    @Override
    public List<UsuarioDto> getAll() {
        var usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new NoDataFoundException("No se encontraron usuarios");
        }
        return usuarioConverter.listModelToDto(usuarios);
    }

    @Override
    public UsuarioDto getById(UsuarioDto usuarioDto) {
        return usuarioConverter.modelToDto(usuarioRepository.getById(usuarioDto.getId()));
    }

    @Override
    public UsuarioDto update(int id, UsuarioDto usuarioDto) {
        var usuario = usuarioConverter.dtoToModel(usuarioDto);
        return usuarioConverter.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);

    }
}
