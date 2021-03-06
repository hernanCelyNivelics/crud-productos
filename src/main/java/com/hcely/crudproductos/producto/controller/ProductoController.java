package com.hcely.crudproductos.producto.controller;

import com.hcely.crudproductos.producto.dto.ProductoDto;
import com.hcely.crudproductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDto> add(@Valid @RequestBody ProductoDto productoDto, BindingResult result) {
        try {
            productoService.add(productoDto);
            if (result.hasErrors()) {
                Logger.getLogger("ocurrio un error en la validacion");
            }
            return new ResponseEntity<>(productoDto, HttpStatus.OK);
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("El numero ingresado no es un decimal");
        }
    }

    @GetMapping("/listado")
    @CrossOrigin("https://www.google.com/")
    public List<ProductoDto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/search")
    public ProductoDto getByNombre(@RequestBody ProductoDto productoDto) {
        return productoService.getByNombre(productoDto);
    }
    @GetMapping("/search/{id}")
    public ProductoDto getById(@RequestBody ProductoDto productoDto) {
        return productoService.getById(productoDto);
    }

    @PutMapping("/{id}")
    public ProductoDto update(@Valid @PathVariable int id, @RequestBody ProductoDto productoDto) {
        return productoService.update(id, productoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable int id) {
        productoService.delete(id);
    }

    @PostMapping("/importcsv")
    public ResponseEntity uploadSingleCSVFile(@RequestParam("csvfile") MultipartFile csvfile) {
        if (csvfile.isEmpty()) {
            return new ResponseEntity("Seleccione un archivo valido", HttpStatus.BAD_REQUEST);
        }
        try {
            productoService.importProductos(csvfile);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Successfully uploaded - " +
                csvfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

}
