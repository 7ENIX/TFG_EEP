package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Repositorio para la entidad de "Uusario" que extiende del repositorio
 * base de JPA, el cual nos da los métodos para realizar el CRUD de la
 * entidad con la que estemos trabajando.
 */
@Repository("GFGUsuarioJpaRepository")
public interface GFGUsuarioJpaRepository extends JpaRepository<UsuarioEntity, Serializable> {

    /**
     * En este Repositorio añadimos un método para poder seleccionar un
     * objeto "Usuario" por su atributo "rol", el cual nos distingue entre
     * el usuario Entrenador y el Cliente.
     * @param rol
     * @return Objeto de tipo UsuarioEntity.
     */
    List<UsuarioEntity> findByRol(int rol);

    /**
     * Método que añadimos y utilizaremos más adelante para realizar el login
     * del usuario, mirando si su email y contraseña en la base de datos. En el
     * caso de ser correcto, el usuario podrá entrar en la aplicación.
     * @param email
     * @param contrasenia
     * @return Objeto de tipo UsuarioEntity.
     */
    UsuarioEntity findByEmailAndContrasenia(String email, String contrasenia);

    /**
     * Método que añadimos para encontrar a un usuario por su id.
     * @param id
     * @return Objeto de tipo UsuarioEntity.
     */
    UsuarioEntity getById(int id);
}

