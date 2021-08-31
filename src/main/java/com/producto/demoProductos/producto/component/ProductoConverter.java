package com.producto.demoProductos.producto.component;

import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.model.Producto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoConverter {

    public ProductoDto modelToDto(Producto producto) {
        var productoDto = new ProductoDto();
        BeanUtils.copyProperties(producto, productoDto);
        return productoDto;
    }

    public List<ProductoDto> listModelToDto(List<Producto> productos) {

        List<ProductoDto> productoDto = new ArrayList<>();
        for (Producto producto : productos) {
            productoDto.add(modelToDto(producto));
        }
        return productoDto;
    }

    public Producto dtoToModel(ProductoDto productoDto) {
        var producto = new Producto();
        BeanUtils.copyProperties(productoDto, producto);
        return producto;
    }
}
