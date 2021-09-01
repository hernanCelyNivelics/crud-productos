package com.hcely.crudproductos.producto.service.impl;

import com.hcely.crudproductos.exception.NoDataFoundException;
import com.hcely.crudproductos.exception.UsuarioExistException;
import com.hcely.crudproductos.producto.component.ProductoMapper;
import com.hcely.crudproductos.producto.dto.ProductoDto;
import com.hcely.crudproductos.producto.repo.ProductoRepository;
import com.hcely.crudproductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    private static final String CAD1 = "El producto ";
    private static final String CAD2 = " no se encontro";

    @Override
    public ProductoDto add(ProductoDto productoDto) {
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        if (productoRepository.findByNombre(producto.getNombre()) != null) {
            throw new UsuarioExistException(CAD1 + producto.getNombre() + " ya existe.");
        }
        return ProductoMapper.mapper.modelToDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDto getByNombre(ProductoDto productoDto) {
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        var productoBuscado = productoRepository.findByNombre(producto.getNombre());
        if (productoBuscado == null) {
            throw new NoDataFoundException(CAD1 + productoDto.getNombreProducto() + CAD2);
        }
        return ProductoMapper.mapper.modelToDto(productoRepository.findByNombre(producto.getNombre()));
    }

    @Override
    public List<ProductoDto> getAll() {
        var usuarios = productoRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new NoDataFoundException("No se encontraron productos");
        }
        return ProductoMapper.mapper.listModeltoDto(usuarios);
    }

    @Override
    public ProductoDto getById(ProductoDto productoDto) {
        var producto = productoRepository.getById(productoDto.getId());
        if (producto == null) {
            throw new NoDataFoundException(CAD1 + productoDto.getNombreProducto() + CAD2);
        }
        return ProductoMapper.mapper.modelToDto(producto);
    }

    @Override
    public ProductoDto update(int id, ProductoDto productoDto) {

        if (!productoRepository.findById(productoDto.getId()).isPresent()) {
            throw new NoDataFoundException(CAD1 + productoDto.getNombreProducto() + CAD2);
        }
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        return ProductoMapper.mapper.modelToDto(productoRepository.save(producto));
    }

    @Override
    public void delete(int id) {
        var producto = productoRepository.getById(id);
        Logger.getLogger(producto.getId() + producto.getNombre());
        if (producto == null) {
            throw new NoDataFoundException("El usuario con ID: " + id + CAD2);
        }
        productoRepository.deleteById(id);

    }
}
