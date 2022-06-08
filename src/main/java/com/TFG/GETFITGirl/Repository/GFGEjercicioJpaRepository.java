package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository("GFGEjercicioJpaRepository")
public interface GFGEjercicioJpaRepository extends JpaRepository<EjercicioEntity, Serializable> {

    EjercicioEntity getById(int id);
}

