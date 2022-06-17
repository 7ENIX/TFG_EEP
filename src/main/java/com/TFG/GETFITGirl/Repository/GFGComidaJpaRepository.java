package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Comidas.ComidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Repositorio para la entidad de "Comida" que extiendendel repositorio
 * base de JPA, el cual nos da los métodos para realizar el CRUD de la
 * entidad con la que estemos trabajando.
 */
@Repository("GFGComidaJpaRepository")
public interface GFGComidaJpaRepository extends JpaRepository<ComidaEntity, Serializable> {
}
