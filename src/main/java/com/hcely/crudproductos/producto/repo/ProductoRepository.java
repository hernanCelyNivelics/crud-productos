package com.hcely.crudproductos.producto.repo;

import com.hcely.crudproductos.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    Producto findByNombre(String nombre);
}
