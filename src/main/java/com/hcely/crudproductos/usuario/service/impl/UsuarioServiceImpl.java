package com.hcely.crudproductos.usuario.service.impl;

import com.hcely.crudproductos.exception.message.NoDataFoundException;
import com.hcely.crudproductos.exception.message.UsuarioExistException;
import com.hcely.crudproductos.usuario.component.UsuarioMapper;
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

    @Override
    public UsuarioDto add(UsuarioDto usuarioDto) {
        var usuario = UsuarioMapper.mapper.dtoToModel(usuarioDto);
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw new UsuarioExistException("El usuario " + usuario.getUsername() + " ya existe.");
        }
        return UsuarioMapper.mapper.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto getByNombre(UsuarioDto usuarioDto) {
        var usuario = UsuarioMapper.mapper.dtoToModel(usuarioDto);
        var usuarioBuscado = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioBuscado == null) {
            throw new NoDataFoundException("El usuario " + usuarioDto.getUsername() + " no se encontro");
        }
        return UsuarioMapper.mapper.modelToDto(usuarioRepository.findByUsername(usuario.getUsername()));
    }

    @Override
    public List<UsuarioDto> getAll() {
        var usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new NoDataFoundException("No se encontraron usuarios");
        }
        return UsuarioMapper.mapper.listModeltoDto(usuarios);
    }

    @Override
    public UsuarioDto getById(UsuarioDto usuarioDto) {
        var usuario = usuarioRepository.getById(usuarioDto.getId());
        if (usuario == null) {
            throw new NoDataFoundException("El usuario " + usuarioDto.getId() + " no se encontro");
        }
        return UsuarioMapper.mapper.modelToDto(usuario);
    }

    @Override
    public UsuarioDto update(int id, UsuarioDto usuarioDto) {

        if (usuarioRepository.getById(usuarioDto.getId()) == null) {
            throw new NoDataFoundException("El usuario con ID:" + usuarioDto.getId() + " no se encontro");
        }

        var usuario = UsuarioMapper.mapper.dtoToModel(usuarioDto);
        return UsuarioMapper.mapper.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public void delete(int id) {
        var usuario = usuarioRepository.getById(id);
        System.out.println(usuario.getId() + usuario.getUsername());
        if (usuario == null) {
            throw new NoDataFoundException("El usuario con ID: " + id + " no se encontro");
        }
        usuarioRepository.deleteById(id);

    }
}
