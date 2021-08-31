package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDto> add(@Valid @RequestBody ProductoDto productoDto, BindingResult result) {
        try {
            var producto = productoService.add(productoDto);
            if (result.hasErrors()) {
                System.out.println("ocurrio un error en la validacion");
            }
            return new ResponseEntity<ProductoDto>(productoDto, HttpStatus.OK);
        }catch (NumberFormatException nf){
            throw new NumberFormatException("El numero ingresado no es un decimal");
        }
    }

    @GetMapping
    public List<ProductoDto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/search")
    public ProductoDto getByNombre(@RequestBody ProductoDto productoDto) {
        return productoService.getByNombre(productoDto);
    }

    @PutMapping("/{id}")
    public ProductoDto update(@Valid @PathVariable int id, @RequestBody ProductoDto productoDto) {
        return productoService.update(id, productoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable int id) {
        productoService.delete(id);
    }
}
