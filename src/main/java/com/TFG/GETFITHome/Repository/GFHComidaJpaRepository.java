package com.TFG.GETFITHome.Repository;

import com.TFG.GETFITHome.Dto.Comidas.ComidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("GFHComidaJpaRepository")
public interface GFHComidaJpaRepository extends JpaRepository<ComidaEntity, Serializable> {

}
