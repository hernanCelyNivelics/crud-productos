package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.model.Usuario;
import com.producto.demoProductos.producto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario add(@RequestBody Usuario usuario)
    {
        return usuarioService.add(usuario);}

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }


    @PutMapping("/{id}")
    public Usuario update(@PathVariable int id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        usuarioService.delete(id);
    }
}
