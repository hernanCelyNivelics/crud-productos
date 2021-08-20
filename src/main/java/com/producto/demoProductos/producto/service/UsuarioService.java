package com.producto.demoProductos.producto.service;


import com.producto.demoProductos.producto.dto.UsuarioDto;
import com.producto.demoProductos.producto.errors.BadRequest;
import com.producto.demoProductos.producto.errors.NegocioException;
import com.producto.demoProductos.producto.errors.NotFound;
import com.producto.demoProductos.producto.model.Usuario;
import com.producto.demoProductos.producto.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    Usuario user = new Usuario();

    public Usuario add(UsuarioDto usuario) throws NegocioException, BadRequest, NotFound {

        user.setUsername(usuario.getUsername());
        user.setPassword(bCrypt(usuario.getPassword()));
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw BadRequest.builder().build();

        } else {
            return usuarioRepository.save(user);

        }

    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(int id, UsuarioDto usuario) throws NotFound {

        if (usuarioRepository.findById(id) == null) {
            throw NotFound.builder().message("No existe el usuario con ID: " + id).build();
        } else {
            user.setUsername(usuario.getUsername());
            user.setPassword(usuario.getPassword());
            return usuarioRepository.save(user);
        }
    }

    public void delete(int id) {
        if (usuarioRepository.findById(id) == null) {
            throw NotFound.builder().message("No existe el usuario con ID: " + id).build();
        } else {
            usuarioRepository.deleteById(id);
        }
    }

    public static String bCrypt(String data) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder.encode(data);
    }
}
