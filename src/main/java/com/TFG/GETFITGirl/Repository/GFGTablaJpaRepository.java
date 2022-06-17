package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Tablas.TablaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Repositorio para la entidad de "Tabla" que extiende del repositorio
 * base de JPA, el cual nos da los métodos para realizar el CRUD de la
 * entidad con la que estemos trabajando.
 */
@Repository("GFGTablaJpaRepository")
public interface GFGTablaJpaRepository extends JpaRepository <TablaEntity, Serializable> {
    List<TablaEntity> findByUsuarioId_Id(int id);

    /**
     * En este Repositorio añadimos un método para poder seleccionar un
     * objeto "Tabla" por su id.
     * @param id
     * @return Objeto de tipo TablaEntity.
     */
    TablaEntity getById(int id);
}
