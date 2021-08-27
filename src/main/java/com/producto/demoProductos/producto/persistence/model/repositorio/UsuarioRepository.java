package com.producto.demoProductos.producto.persistence.model.repositorio;

import com.producto.demoProductos.producto.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername(String username);
    Usuario findById(int id);
}
