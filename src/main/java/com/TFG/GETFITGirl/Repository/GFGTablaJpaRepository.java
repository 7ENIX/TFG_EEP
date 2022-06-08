package com.TFG.GETFITGirl.Repository;

import com.TFG.GETFITGirl.Dto.Tablas.TablaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository("GFGTablaJpaRepository")
public interface GFGTablaJpaRepository extends JpaRepository <TablaEntity, Serializable> {
    List<TablaEntity> findByUsuarioId_Id(int id);

    TablaEntity getById(int id);
}
