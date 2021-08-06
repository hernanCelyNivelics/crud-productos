package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.model.Usuario;
import com.producto.demoProductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto add(@RequestBody Producto producto)
    {
        return productoService.add(producto);}

    @GetMapping
    public List<Producto> getAll(){
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public List<Producto> getProducto(@PathVariable("id") int id){
        return productoService.getProducto(id);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable int id, @RequestBody Producto producto){
        return productoService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productoService.delete(id);
    }
}
