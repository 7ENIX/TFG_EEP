package com.TFG.GETFITHome.Repository;

import com.TFG.GETFITHome.Dto.Tablas.TablaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("GFHTablaJpaRepository")
public interface GFHTablaJpaRepository extends JpaRepository <TablaEntity, Serializable> {
    List<TablaEntity> findByUsuarioId_Id(int id);

}
