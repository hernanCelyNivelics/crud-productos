package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto add(@RequestBody Producto producto)
    { return productoService.add(producto);}

    @GetMapping
    public List<Producto> getAll(){
        return productoService.getAll();
    }

    @PutMapping("/{pro_id}")
    public Producto update(@PathVariable int pro_id, @RequestBody Producto producto){
        return productoService.update(pro_id, producto);
    }

    @DeleteMapping("/{pro_id}")
    public void delete(@PathVariable int pro_id){
        productoService.delete(pro_id);
    }
}
