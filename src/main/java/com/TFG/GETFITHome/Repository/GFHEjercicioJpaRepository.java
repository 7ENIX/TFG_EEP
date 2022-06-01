package com.TFG.GETFITHome.Repository;

import com.TFG.GETFITHome.Dto.Ejercicio.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("GFHEjercicioJpaRepository")
public interface GFHEjercicioJpaRepository extends JpaRepository<EjercicioEntity, Serializable> {
}

