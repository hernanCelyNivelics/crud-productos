package com.producto.demoProductos.producto.web.controller;

import com.producto.demoProductos.producto.domain.dto.ProductoDto;

import com.producto.demoProductos.producto.errors.BadRequestExcepiton;
import com.producto.demoProductos.producto.errors.FoundException;
import com.producto.demoProductos.producto.errors.NotFoundException;

import com.producto.demoProductos.producto.errors.ProductoException;
import com.producto.demoProductos.producto.persistence.model.Producto;
import com.producto.demoProductos.producto.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController

@Validated
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/add")
    @ResponseBody
    public Producto add(@Valid @RequestBody ProductoDto productodto, BindingResult result) throws FoundException, HttpMessageNotReadableException {

        if (result.hasErrors()) {
            System.out.println("Se generaron errores" + result.getAllErrors());
            return (Producto) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        } else {
            return productoService.add(productodto);
        }
    }

    @GetMapping("/listado")
    public List<Producto> getAll() {
        return productoService.getAll();
    }

    @CrossOrigin(origins = "https://www.google.com")
    @GetMapping("/search/{id}")
    public List<Producto> getProducto(@PathVariable("id") int id)throws ProductoException {
        return productoService.getProducto(id);
    }

    @PutMapping("/update/{id}")
    public Producto update(@PathVariable int id, @RequestBody ProductoDto productodto) {
        return productoService.update(id, productodto);
    }

    @DeleteMapping("/delete/{id}")

    public void delete(@PathVariable int id) throws NotFoundException {

        productoService.delete(id);
    }
}
