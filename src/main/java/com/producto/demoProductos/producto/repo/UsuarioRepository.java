package com.producto.demoProductos.producto.repo;

import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
}
