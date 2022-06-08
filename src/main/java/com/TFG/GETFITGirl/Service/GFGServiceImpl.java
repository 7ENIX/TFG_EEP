package com.TFG.GETFITGirl.Service;

import com.TFG.GETFITGirl.Dto.Comidas.ComidaDTO;
import com.TFG.GETFITGirl.Dto.Comidas.ComidaEntity;
import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioDTO;
import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITGirl.Dto.Tablas.TablaDTO;
import com.TFG.GETFITGirl.Dto.Tablas.TablaEntity;
import com.TFG.GETFITGirl.Dto.Tablas.TablaResponse;
import com.TFG.GETFITGirl.Dto.Usuario.UsuarioDTO;
import com.TFG.GETFITGirl.Dto.Usuario.UsuarioEntity;
import com.TFG.GETFITGirl.Repository.GFGComidaJpaRepository;
import com.TFG.GETFITGirl.Repository.GFGEjercicioJpaRepository;
import com.TFG.GETFITGirl.Repository.GFGTablaJpaRepository;
import com.TFG.GETFITGirl.Repository.GFGUsuarioJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("GFHServiceImpl")
public class GFGServiceImpl implements GFGService {

    // :::::::::::::::::::: VARIABLES :::::::::::::::::::: //
    @Autowired
    private GFGUsuarioJpaRepository GFGUsuarioJpaRepository;

    @Autowired
    private GFGEjercicioJpaRepository GFGEjercicioJpaRepository;

    @Autowired
    private GFGComidaJpaRepository GFGComidaJpaRepository;

    @Autowired
    private GFGTablaJpaRepository GFGTablaJpaRepository;


    // :::::::::::::::::::::: MÉTODOS PARA USUARIOS :::::::::::::::::::::: //

    @Override
    public List<UsuarioEntity> listadoUsuarios() {
        return GFGUsuarioJpaRepository.findAll();
    }

    @Override
    public UsuarioEntity añadirUsuario(UsuarioEntity usuarioEntity) {
        return GFGUsuarioJpaRepository.save(usuarioEntity);
    }

    @Override
    public int eliminarUsuario(int id) {
        List<TablaEntity> lista = GFGTablaJpaRepository.findByUsuarioId_Id(id);
        if (lista.size() > 0){
            for (TablaEntity i : lista) {
                eliminarTabla(i.getId());
            }
        }
        GFGUsuarioJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public UsuarioEntity modificarUsuario(UsuarioEntity usuarioEntity) {
        return GFGUsuarioJpaRepository.save(usuarioEntity);
    }

    @Override
    public UsuarioEntity login (UsuarioDTO usuario) {
        UsuarioEntity temp = GFGUsuarioJpaRepository.findByEmailAndContrasenia(usuario.getEmail(), usuario.getContrasenia());
        return temp;
    }

    @Override
    public UsuarioEntity findUsuarioById(int id) {
        return GFGUsuarioJpaRepository.getById(id);
    }

    @Override
    public List<UsuarioEntity> findUsuarioByRol(int id) {
        return GFGUsuarioJpaRepository.findByRol(id);
    }

    @Override
    public Boolean validacionUsuario(UsuarioDTO usuario) {return null;}

    @Override
    public Boolean validacionFechaNacimiento(String fecha) {
        LocalDate fechaNacimiento = LocalDate.parse(fecha);

        LocalDate birthdate = LocalDate.parse(fecha);
        long edad = ChronoUnit.YEARS.between(birthdate, LocalDate.now());

        if (edad>=18){
            return true;
        }
        return false;
    }


    // :::::::::::::::::::::: MÉTODOS PARA EJERCICIOS :::::::::::::::::::::: //
    @Override
    public List<EjercicioEntity> listadoEjercicios() {
        return GFGEjercicioJpaRepository.findAll();
    }

    @Override
    public EjercicioEntity añadirEjercicio(EjercicioEntity ejercicioEntity) {
        return GFGEjercicioJpaRepository.save(ejercicioEntity);
    }

    @Override
    public int eliminarEjercicio(int id) {
        GFGEjercicioJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public EjercicioEntity modificarEjercicio(EjercicioEntity ejercicioEntity) {
        GFGEjercicioJpaRepository.save(ejercicioEntity);
        return null;
    }

    @Override
    public EjercicioEntity findEjercicioById(int id) {
        return GFGEjercicioJpaRepository.getById(id);
    }


    // :::::::::::::::::::::: MÉTODOS PARA COMIDAS :::::::::::::::::::::: //
    @Override
    public List<ComidaEntity> listadoComida() {
        return GFGComidaJpaRepository.findAll();
    }

    @Override
    public ComidaEntity añadirComida(ComidaEntity comidaEntity) {
        return GFGComidaJpaRepository.save(comidaEntity);
    }

    @Override
    public int eliminarComida(int id) {
        GFGComidaJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public ComidaEntity modificarComida(ComidaEntity comidaEntity) {
        GFGComidaJpaRepository.save(comidaEntity);
        return null;
    }

    @Override
    public Optional<ComidaEntity> findComidaById(int id) {
        return GFGComidaJpaRepository.findById(id);
    }

    // :::::::::::::::::::::: MÉTODOS PARA TABLAS :::::::::::::::::::::: //
    @Override
    public List<TablaEntity> listadoTabla(int id) {
        return GFGTablaJpaRepository.findByUsuarioId_Id(id);
    }

    @Override
    public TablaEntity añadirTabla(TablaEntity tablaEntity) {
        return GFGTablaJpaRepository.save(tablaEntity);
    }

    @Override
    public int eliminarTabla(int id) {
        GFGTablaJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public TablaEntity modificarTabla(TablaEntity tablaEntity) {
        return GFGTablaJpaRepository.save(tablaEntity);
    }

    @Override
    public TablaEntity findTablaById(int id) {
        return GFGTablaJpaRepository.getById(id);
    }

    @Override
    public List<TablaEntity> findTablaByUsuarioId(int id) {
        return GFGTablaJpaRepository.findByUsuarioId_Id(id);
    }


    // :::::::::::::::::::::: MÉTODOS PARA CASTEAR :::::::::::::::::::::: //
    @Override
    public UsuarioDTO usuarioEntityaDTOMM(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new ModelMapper().map(usuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public UsuarioEntity usuarioDTOaEntityMM(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new ModelMapper().map(usuarioDTO, UsuarioEntity.class);
        return usuarioEntity;
    }

    @Override
    public EjercicioDTO ejercicioEntityaDTOMM(EjercicioEntity ejercicioEntity) {
        EjercicioDTO ejercicioDTO = new ModelMapper().map(ejercicioEntity, EjercicioDTO.class);
        return ejercicioDTO;
    }


    @Override
    public EjercicioEntity ejercicioDTOaEntityMM(EjercicioDTO ejercicioDTO) {
        EjercicioEntity ejercicioEntity = new ModelMapper().map(ejercicioDTO, EjercicioEntity.class);
        return ejercicioEntity;
    }

    @Override
    public ComidaDTO comidaEntityaDTOMM(ComidaEntity comidaEntity) {
        ComidaDTO comidaDTO = new ModelMapper().map(comidaEntity, ComidaDTO.class);
        return comidaDTO;
    }

    @Override
    public ComidaEntity comidaDTOaEntityMM(ComidaDTO comidaDTO) {
        ComidaEntity comidaEntity = new ModelMapper().map(comidaDTO, ComidaEntity.class);
        return comidaEntity;
    }

    @Override
    public TablaDTO tablaEntityaDTOMM(TablaEntity tablaEntity) {
        TablaDTO tablaDTO = new ModelMapper().map(tablaEntity, TablaDTO.class);
        return tablaDTO;
    }

    @Override
    public TablaEntity tablaDTOaEntityMM(TablaDTO tablaDTO) {
        TablaEntity tablaEntity = new ModelMapper().map(tablaDTO, TablaEntity.class);
        return tablaEntity;
    }

    @Override
    public TablaResponse tablaEntityaResponse(TablaEntity tablaEntity) {
        TablaResponse tablaResponse = new TablaResponse();
        tablaResponse.setId(tablaEntity.getId());
        tablaResponse.setEjercicioNombre(findEjercicioById(tablaEntity.getId()).getNombre());
        tablaResponse.setSeries(tablaEntity.getSeries());
        tablaResponse.setRepeticiones(tablaEntity.getRepeticiones());
        tablaResponse.setPeso(tablaEntity.getPeso());
        tablaResponse.setIntensidad(tablaEntity.getIntensidad());
        tablaResponse.setDuracion(tablaEntity.getDuracion());
        tablaResponse.setDescanso(tablaEntity.getDescanso());
        tablaResponse.setUrl(findEjercicioById(tablaEntity.getId()).getUrl());
        return tablaResponse;
    }

    @Override
    public List<TablaResponse> tablaEjercicios(List<TablaEntity> lista) {
        List<TablaResponse> tabla = new ArrayList<>();
        for (TablaEntity i: lista) {
            tabla.add(tablaEntityaResponse(i));
        }
        return tabla;
    }
}