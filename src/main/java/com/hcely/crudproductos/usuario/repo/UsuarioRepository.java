package com.hcely.crudproductos.usuario.repo;

import com.hcely.crudproductos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByUsername(String nombre);
}
