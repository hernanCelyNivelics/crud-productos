package com.producto.demoProductos.producto.service;



import java.util.List;

import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.model.Usuario;
import com.producto.demoProductos.producto.repo.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    Producto product = new Producto();
    public Producto add(ProductoDto producto){
        product.setNombre(producto.getNombre());
        product.setPrecio(Float.parseFloat(producto.getPrecio()));
        return productoRepository.save(product);
    }

    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public List<Producto> getProducto(int id){
        return productoRepository.findById(id);
    }

    public Producto update(int id, ProductoDto productodto){
        product.setNombre(productodto.getNombre());
        product.setPrecio(Float.parseFloat(productodto.getPrecio()));
        return productoRepository.save(product);
    }

    public void delete(int id){ productoRepository.deleteById(id);
    }

}
