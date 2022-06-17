package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


/**
 * Repositorio para la entidad de "Ejercicio" que extiende del repositorio
 * base de JPA, el cual nos da los métodos para realizar el CRUD de la
 * entidad con la que estemos trabajando.
 */
@Repository("GFGEjercicioJpaRepository")
public interface GFGEjercicioJpaRepository extends JpaRepository<EjercicioEntity, Serializable> {

    /**
     * En este Repositorio añadimos un método para poder seleccionar un
     * objeto "Ejercicio" por su id.
     * @param id
     * @return Objeto de tipo EjercicioEntity.
     */
    EjercicioEntity getById(int id);
}

