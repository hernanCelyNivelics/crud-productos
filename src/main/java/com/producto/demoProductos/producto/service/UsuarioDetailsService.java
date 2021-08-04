package com.producto.demoProductos.producto.service;
import com.producto.demoProductos.producto.dto.AuthenticationRequest;
import com.producto.demoProductos.producto.model.Usuario;
import com.producto.demoProductos.producto.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //Usuario usuario = usuarioRepository.findByUsername(s);
        return new User("admin","password", new ArrayList<>());
    }
}
