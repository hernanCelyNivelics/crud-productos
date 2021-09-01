package com.hcely.crudproductos.usuario.service.impl;

import com.hcely.crudproductos.exception.NoDataFoundException;
import com.hcely.crudproductos.exception.UsuarioExistException;
import com.hcely.crudproductos.usuario.component.UsuarioConverter;
import com.hcely.crudproductos.usuario.dto.UsuarioDto;
import com.hcely.crudproductos.usuario.repo.UsuarioRepository;
import com.hcely.crudproductos.usuario.service.UsuarioService;
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
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw new UsuarioExistException("El usuario " + usuario.getUsername() + " ya existe.");
        }
        return usuarioConverter.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto getByNombre(UsuarioDto usuarioDto) {
        var usuario = usuarioConverter.dtoToModel(usuarioDto);
        var usuarioBuscado = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioBuscado == null) {
            throw new NoDataFoundException("El usuario " + usuarioDto.getUsername() + " no se encontro");
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
        var usuario= usuarioRepository.getById(usuarioDto.getId());
        if (usuario==null){
           throw new NoDataFoundException("El usuario " + usuarioDto.getId() + " no se encontro");
        }
        return usuarioConverter.modelToDto(usuario);
    }

    @Override
    public UsuarioDto update(int id, UsuarioDto usuarioDto) {

        if (usuarioRepository.getById(usuarioDto.getId())==null){
            throw new NoDataFoundException("El usuario con ID:" + usuarioDto.getId() + " no se encontro");
        }
        var usuario = usuarioConverter.dtoToModel(usuarioDto);
        return usuarioConverter.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public void delete(int id) {
    var usuario=usuarioRepository.getById(id);
        System.out.println(usuario.getId()+usuario.getUsername());
        if (usuario==null){
            throw new NoDataFoundException("El usuario con ID: " + id + " no se encontro");
        }
        usuarioRepository.deleteById(id);

    }
}
