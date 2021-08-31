package com.producto.demoProductos.usuario.repo;

import com.producto.demoProductos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByUsername(String nombre);
}
