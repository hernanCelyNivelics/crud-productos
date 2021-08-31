package com.producto.demoProductos.producto.repo;

import com.producto.demoProductos.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    Producto findByNombre(String nombre);
}
