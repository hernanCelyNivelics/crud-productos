package com.producto.demoProductos.producto.repo;

import com.producto.demoProductos.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByPro_nombre(String pro_nombre);
}
