package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.errors.BadRequest;
import com.producto.demoProductos.producto.errors.NegocioException;
import com.producto.demoProductos.producto.errors.NotFound;
import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/add")
    public Producto add(@RequestBody ProductoDto productodto) throws NegocioException, BadRequest, NotFound
    {
        return productoService.add(productodto);}

    @GetMapping("/listado")
    public List<Producto> getAll(){
        return productoService.getAll();
    }

    @GetMapping("/get/{id}")
    public List<Producto> getProducto(@PathVariable("id") int id){
        return productoService.getProducto(id);
    }

    @PutMapping("/update/{id}")
    public Producto update(@PathVariable int id, @RequestBody ProductoDto productodto){
        return productoService.update(id, productodto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) throws NotFound{
        productoService.delete(id);
    }
}
