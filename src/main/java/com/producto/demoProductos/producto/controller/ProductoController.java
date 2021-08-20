package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.dto.ProductoDto;

import com.producto.demoProductos.producto.errors.BadRequest;
import com.producto.demoProductos.producto.errors.NotFound;

import com.producto.demoProductos.producto.errors.ProductoException;

import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController


@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    private Producto producto;


    @PostMapping("/add")

    @ResponseBody
    public Producto add(@RequestBody ProductoDto productodto) throws BadRequest
    {
        return productoService.add(productodto);}



    @PostMapping("/import")
    public Object importProductos(@RequestParam MultipartFile productos) {
        return productoService.importProductos(productos);
    }


    @GetMapping("/listado")
    public List<Producto> getAll() {
        return productoService.getAll();
    }

    @CrossOrigin(origins = "https://www.google.com")
    @GetMapping("/search/{id}")
    public List<Producto> getProducto(@PathVariable("id") int id) {
        return productoService.getProducto(id);
    }

    @PutMapping("/update/{id}")
    public Producto update(@PathVariable int id, @RequestBody ProductoDto productodto) {
        return productoService.update(id, productodto);
    }

    @DeleteMapping("/delete/{id}")

    public void delete(@PathVariable int id) throws NotFound{

        productoService.delete(id);
    }
}
