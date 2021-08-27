package com.producto.demoProductos.producto.domain.service;


import com.producto.demoProductos.producto.domain.dto.UsuarioDto;
import com.producto.demoProductos.producto.errors.BadRequestExcepiton;
import com.producto.demoProductos.producto.errors.FoundException;
import com.producto.demoProductos.producto.errors.NegocioException;
import com.producto.demoProductos.producto.errors.NotFoundException;
import com.producto.demoProductos.producto.message.ApiError;
import com.producto.demoProductos.producto.persistence.model.Usuario;
import com.producto.demoProductos.producto.persistence.model.repositorio.UsuarioRepository;
import com.producto.demoProductos.producto.web.controller.ErrorHandlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario add(UsuarioDto usuario) throws FoundException {
        Usuario user = new Usuario();
        user.setUsername(usuario.getUsername());
        user.setPassword(bCrypt(usuario.getPassword()));
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw FoundException.builder()
                    .status(HttpStatus.FOUND)
                    .message("El usuario "+user.getUsername()+" ya esiste")
                    .errors("El usuario ya existe").build();
        } else {

            return usuarioRepository.save(user);

        }

    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(int id, UsuarioDto usuario) throws NotFoundException {
        Usuario user = new Usuario();
        if (usuarioRepository.findById(id) == null) {
            throw NotFoundException.builder().message("No existe el usuario con ID: " + id).build();
        } else {
            user.setId(id);
            user.setUsername(usuario.getUsername());
            user.setPassword(usuario.getPassword());
            return usuarioRepository.save(user);
        }
    }

    public void delete(int id) {
        if (usuarioRepository.findById(id) == null) {
            throw NotFoundException.builder().message("No existe el usuario con ID: " + id).build();
        } else {
            usuarioRepository.deleteById(id);
        }
    }

    public static String bCrypt(String data) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder.encode(data);
    }
}
