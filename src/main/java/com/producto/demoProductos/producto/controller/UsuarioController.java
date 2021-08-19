package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.dto.UsuarioDto;
import com.producto.demoProductos.producto.errors.NegocioException;
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
    private Usuario usuario;
    @PostMapping("/add")
    @ResponseBody
    public Usuario add(@RequestBody UsuarioDto usuariodto) throws NegocioException
    {
        return usuarioService.add(usuariodto);}

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable int id, @RequestBody UsuarioDto usuario){
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        usuarioService.delete(id);
    }
}
