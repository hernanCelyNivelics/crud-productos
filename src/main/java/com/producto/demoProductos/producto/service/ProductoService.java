package com.producto.demoProductos.producto.service;

import com.producto.demoProductos.producto.dto.ProductoDto;

import java.util.List;


public interface ProductoService {

    ProductoDto add(ProductoDto productoDto);

    List<ProductoDto> getAll();

    ProductoDto getById(ProductoDto productoDto);

    ProductoDto getByNombre(ProductoDto productoDto);

    ProductoDto update(int id, ProductoDto productoDto);

    void delete(int id);
}
