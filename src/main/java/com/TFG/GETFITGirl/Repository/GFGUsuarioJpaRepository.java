package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("GFGUsuarioJpaRepository")
public interface GFGUsuarioJpaRepository extends JpaRepository<UsuarioEntity, Serializable> {

    List<UsuarioEntity> findByRol(int rol);

    UsuarioEntity findByEmailAndContrasenia(String email, String contrasenia);

    UsuarioEntity getById(int id);
}

