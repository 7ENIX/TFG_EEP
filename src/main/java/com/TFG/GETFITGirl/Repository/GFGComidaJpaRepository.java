package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Comidas.ComidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("GFGComidaJpaRepository")
public interface GFGComidaJpaRepository extends JpaRepository<ComidaEntity, Serializable> {

}
