package com.producto.demoProductos.producto.service.impl;

import com.producto.demoProductos.exception.NoDataFoundException;
import com.producto.demoProductos.exception.UsuarioExistException;
import com.producto.demoProductos.producto.component.ProductoConverter;
import com.producto.demoProductos.producto.component.ProductoMapper;
import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.repo.ProductoRepository;
import com.producto.demoProductos.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;



    @Autowired
    private ProductoConverter productoConverter;

    @Override
    public ProductoDto add(ProductoDto productoDto) {
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        if (productoRepository.findByNombre(producto.getNombre()) != null) {
            throw new UsuarioExistException("El producto " + producto.getNombre() + " ya existe.");
        }
        return ProductoMapper.mapper.modelToDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDto getByNombre(ProductoDto productoDto) {
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        var productoBuscado = productoRepository.findByNombre(producto.getNombre());
        if (productoBuscado == null) {
            throw new NoDataFoundException("El producto " + productoDto.getNombreProducto() + " no se encontro");
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
            throw new NoDataFoundException("El producto " + productoDto.getNombreProducto() + " no se encontro");
        }
        return ProductoMapper.mapper.modelToDto(producto);
    }

    @Override
    public ProductoDto update(int id, ProductoDto productoDto) {

        if (productoRepository.findById(productoDto.getId()) == null) {
            throw new NoDataFoundException("El producto con " + productoDto.getNombreProducto() + " no se encontro");
        }
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        return ProductoMapper.mapper.modelToDto(productoRepository.save(producto));
    }

    @Override
    public void delete(int id) {
        var producto = productoRepository.getById(id);
        System.out.println(producto.getId() + producto.getNombre());
        if (producto == null) {
            throw new NoDataFoundException("El usuario con ID: " + id + " no se encontro");
        }
        productoRepository.deleteById(id);

    }
}
