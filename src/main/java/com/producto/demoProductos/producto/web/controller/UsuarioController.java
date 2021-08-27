package com.producto.demoProductos.producto.web.controller;

import com.producto.demoProductos.producto.domain.dto.UsuarioDto;
import com.producto.demoProductos.producto.errors.BadRequestExcepiton;
import com.producto.demoProductos.producto.errors.FoundException;
import com.producto.demoProductos.producto.errors.NegocioException;
import com.producto.demoProductos.producto.errors.NotFoundException;
import com.producto.demoProductos.producto.persistence.model.Usuario;
import com.producto.demoProductos.producto.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private Usuario usuario;

    @PostMapping("/add")
    @ResponseBody
    public Usuario add(@Valid @RequestBody UsuarioDto usuariodto, BindingResult result) throws FoundException
    {

        if (result.hasErrors()){
            System.out.println("tiene errores");
            return usuarioService.add(usuariodto) ;
        }
        return usuarioService.add(usuariodto);}

    @GetMapping("/")
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
