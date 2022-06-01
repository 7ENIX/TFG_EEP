package com.TFG.GETFITHome.Service;

import com.TFG.GETFITHome.Dto.Comidas.ComidaEntity;
import com.TFG.GETFITHome.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITHome.Dto.Tablas.TablaEntity;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioDTO;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface GFHService {

    // :::::::::::::::::::::: MÉTODOS PARA USUARIOS :::::::::::::::::::::: //
    List<UsuarioEntity> listadoUsuarios();

    UsuarioEntity añadirUsuario(UsuarioEntity usuarioEntity);

    int eliminarUsuario(int id);

    UsuarioEntity modificarUsuario(UsuarioEntity usuarioEntity);

    UsuarioEntity login(UsuarioDTO usuario);

    Optional<UsuarioEntity> findUsuarioById(int id);

    List<UsuarioEntity> findUsuarioByRol(int id);

    Boolean validacionUsuario(UsuarioDTO usuario);

    Boolean validacionFechaNacimiento(String fecha);

    UsuarioEntity casteoDTOaEntity(UsuarioDTO usuarioDTO);


    // :::::::::::::::::::::: MÉTODOS PARA EJERCICIOS :::::::::::::::::::::: //
    List<EjercicioEntity> listadoEjercicios();

    EjercicioEntity añadirEjercicio(EjercicioEntity ejercicioEntity);

    int eliminarEjercicio(int id);

    EjercicioEntity modificarEjercicio(EjercicioEntity ejercicioEntity);

    Optional<EjercicioEntity> findEjercicioById(int id);


    // :::::::::::::::::::::: MÉTODOS PARA COMIDAS :::::::::::::::::::::: //
    List<ComidaEntity> listadoComida();

    ComidaEntity añadirComida(ComidaEntity comidaEntity);

    int eliminarComida(int id);

    ComidaEntity modificarComida(ComidaEntity comidaEntity);

    Optional<ComidaEntity> findComidaById(int id);


    // :::::::::::::::::::::: MÉTODOS PARA TABLAS :::::::::::::::::::::: //
    List<TablaEntity> listadoTabla();

    TablaEntity añadirTabla(TablaEntity tablaEntity);

    int eliminarTabla(int id);

    TablaEntity modificarTabla(TablaEntity tablaEntity);

    Optional<TablaEntity> findTablaById(int id);

    List<TablaEntity> findTablaByUsuarioId(int id);
}
