package com.hcely.crudproductos.producto.service;

import com.hcely.crudproductos.producto.dto.ProductoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductoService {

    ProductoDto add(ProductoDto productoDto);

    List<ProductoDto> getAll();

    ProductoDto getById(ProductoDto productoDto);

    ProductoDto getByNombre(ProductoDto productoDto);

    ProductoDto update(int id, ProductoDto productoDto);

    void delete(int id);

    Object importProductos(MultipartFile productos);
}
