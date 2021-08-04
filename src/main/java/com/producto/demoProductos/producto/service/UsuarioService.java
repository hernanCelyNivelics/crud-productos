package com.producto.demoProductos.producto.service;


import com.producto.demoProductos.producto.model.Usuario;
import com.producto.demoProductos.producto.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario add(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario update(int id, Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(int id){ usuarioRepository.deleteById(id);
    }
}
