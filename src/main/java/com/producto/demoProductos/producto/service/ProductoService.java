package com.producto.demoProductos.producto.service;


import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.errors.BadRequest;
import com.producto.demoProductos.producto.errors.NotFound;
import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.repo.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto add(ProductoDto producto) throws BadRequest {
        Producto product = new Producto();
        product.setNombre(producto.getNombre());
        product.setPrecio(Float.parseFloat(producto.getPrecio()));
        if (productoRepository.findByNombre(producto.getNombre()) != null) {
            throw BadRequest.builder().build();

        } else {
            return productoRepository.save(product);
        }


    }

    public List<Producto> getAll() {

        return productoRepository.findAll();
    }

    public List<Producto> getProducto(int id) {

        if (productoRepository.findById(id) == null) {
            throw NotFound.builder().message("No existe el producto con ID: " + id).build();
        }else{
            return productoRepository.findById(id);
        }
    }

    public Producto update(int id, ProductoDto productodto) throws NotFound{
        Producto product = new Producto();
        if (productoRepository.findById(id) == null) {
            throw NotFound.builder().message("No existe el producto con ID: " + id).build();
        } else {
            product.setId(id);
            product.setNombre(productodto.getNombre());
            product.setPrecio(Float.parseFloat(productodto.getPrecio()));
            return productoRepository.save(product);
        }

    }

    public void delete(int id) throws NotFound {

        if (productoRepository.findById(id)==null){
           throw NotFound.builder().message("No existe el producto con ID: " + id).build();
       }else{
           productoRepository.deleteById(id);

       }
    }

}
