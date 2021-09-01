package com.hcely.crudproductos.producto.component;

import com.hcely.crudproductos.producto.dto.ProductoDto;
import com.hcely.crudproductos.producto.model.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {


    ProductoMapper mapper = Mappers.getMapper(ProductoMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "precio", target = "precioProducto")
    @Mapping(source = "nombre", target = "nombreProducto")
    ProductoDto modelToDto(Producto producto);

    List<ProductoDto> listModeltoDto(List<Producto> productoDto);

    @InheritInverseConfiguration
    Producto dtoToModel(ProductoDto productoDto);

}
