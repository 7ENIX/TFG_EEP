package com.TFG.GETFITHome.Repository;

import com.TFG.GETFITHome.Dto.Usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("GFHUsuarioJpaRepository")
public interface GFHUsuarioJpaRepository extends JpaRepository<UsuarioEntity, Serializable> {

    List<UsuarioEntity> findByRol(int rol);

    UsuarioEntity findByEmailAndContrasenia(String email, String contrasenia);
}

