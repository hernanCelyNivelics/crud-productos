package com.hcely.crudproductos.usuario.controller;

import com.hcely.crudproductos.usuario.dto.UsuarioDto;
import com.hcely.crudproductos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> add(@Valid @RequestBody UsuarioDto usuarioDto, BindingResult result) {
        usuarioService.add(usuarioDto);
        if (result.hasErrors()) {
            Logger.getLogger("ocurrio un error en la validacion");
        }

        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }

    @GetMapping
    public List<UsuarioDto> getAll() {
        return usuarioService.getAll();
    }

    @GetMapping("/search")
    public UsuarioDto getByNombre(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.getByNombre(usuarioDto);
    }

    @PutMapping("/{id}")
    public UsuarioDto update(@Valid @PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.update(id, usuarioDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable int id) {
        usuarioService.delete(id);
    }


}
