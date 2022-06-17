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

import java.util.List;
import java.util.Optional;

public interface GFGService {

    /**
     * Todos los comentarios que describen cada método están en "GFGServiceImpl".
     */

    // :::::::::::::::::::::: MÉTODOS PARA USUARIOS :::::::::::::::::::::: //
    List<UsuarioEntity> listadoUsuarios();

    UsuarioEntity añadirUsuario(UsuarioEntity usuarioEntity);

    int eliminarUsuario(int id);

    UsuarioEntity modificarUsuario(UsuarioEntity usuarioEntity);

    UsuarioEntity login(UsuarioDTO usuario);

    UsuarioEntity findUsuarioById(int id);

    List<UsuarioEntity> findUsuarioByRol(int id);

    Boolean validacionFechaNacimiento(String fecha);


    // :::::::::::::::::::::: MÉTODOS PARA EJERCICIOS :::::::::::::::::::::: //
    List<EjercicioEntity> listadoEjercicios();

    EjercicioEntity añadirEjercicio(EjercicioEntity ejercicioEntity);

    int eliminarEjercicio(int id);

    EjercicioEntity modificarEjercicio(EjercicioEntity ejercicioEntity);

    EjercicioEntity findEjercicioById(int id);


    // :::::::::::::::::::::: MÉTODOS PARA COMIDAS :::::::::::::::::::::: //
    List<ComidaEntity> listadoComida();

    ComidaEntity añadirComida(ComidaEntity comidaEntity);

    int eliminarComida(int id);

    ComidaEntity modificarComida(ComidaEntity comidaEntity);

    Optional<ComidaEntity> findComidaById(int id);


    // :::::::::::::::::::::: MÉTODOS PARA TABLAS :::::::::::::::::::::: //
    List<TablaEntity> listadoTabla(int id);

    TablaEntity añadirTabla(TablaEntity tablaEntity);

    int eliminarTabla(int id);

    TablaEntity modificarTabla(TablaEntity tablaEntity);

    TablaEntity findTablaById(int id);

    List<TablaEntity> findTablaByUsuarioId(int id);


    // :::::::::::::::::::::: MÉTODOS PARA CASTEAR :::::::::::::::::::::: //

    //Casteos de la clase Usuario.
    UsuarioDTO usuarioEntityaDTOMM(UsuarioEntity usuarioEntity);
    UsuarioEntity usuarioDTOaEntityMM(UsuarioDTO usuarioDTO);

    //Casteos de la clase Ejercicio.
    EjercicioDTO ejercicioEntityaDTOMM(EjercicioEntity ejercicioEntity);
    EjercicioEntity ejercicioDTOaEntityMM(EjercicioDTO ejercicioDTO);

    //Casteos de la clase Comida.
    ComidaDTO comidaEntityaDTOMM(ComidaEntity comidaEntity);
    ComidaEntity comidaDTOaEntityMM(ComidaDTO comidaDTO);

    //Casteos de la clase TABLA.
    TablaDTO tablaEntityaDTOMM(TablaEntity tablaEntity);
    TablaEntity tablaDTOaEntityMM(TablaDTO tablaDTO);
    TablaResponse tablaEntityaResponse(TablaEntity tablaEntity);

    //Casteo para una lista de objetos tipo Tabla.
    List<TablaResponse> tablaEjercicios(List<TablaEntity> lista);

}
