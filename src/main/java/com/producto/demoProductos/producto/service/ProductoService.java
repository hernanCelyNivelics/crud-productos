package com.producto.demoProductos.producto.service;



import java.util.List;

import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.repo.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto add(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public List<Producto> getProducto(int id){
        return productoRepository.findById(id);
    }

    public Producto update(int id, Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(int id){ productoRepository.deleteById(id);
    }

}
