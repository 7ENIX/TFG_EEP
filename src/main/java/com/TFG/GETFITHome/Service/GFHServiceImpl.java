package com.TFG.GETFITHome.Service;

import com.TFG.GETFITHome.Dto.Comidas.ComidaEntity;
import com.TFG.GETFITHome.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITHome.Dto.Tablas.TablaEntity;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioDTO;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioEntity;
import com.TFG.GETFITHome.Repository.GFHComidaJpaRepository;
import com.TFG.GETFITHome.Repository.GFHEjercicioJpaRepository;
import com.TFG.GETFITHome.Repository.GFHTablaJpaRepository;
import com.TFG.GETFITHome.Repository.GFHUsuarioJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@Service("GFHServiceImpl")
public class GFHServiceImpl implements GFHService {

    // :::::::::::::::::::: VARIABLES :::::::::::::::::::: //
    @Autowired
    private GFHUsuarioJpaRepository gfhUsuarioJpaRepository;

    @Autowired
    private GFHEjercicioJpaRepository gfhEjercicioJpaRepository;

    @Autowired
    private GFHComidaJpaRepository gfhComidaJpaRepository;

    @Autowired
    private GFHTablaJpaRepository gfhTablaJpaRepository;


    // :::::::::::::::::::::: MÉTODOS PARA USUARIOS :::::::::::::::::::::: //



    @Override
    public List<UsuarioEntity> listadoUsuarios() {
        return gfhUsuarioJpaRepository.findAll();
    }

    @Override
    public UsuarioEntity añadirUsuario(UsuarioEntity usuarioEntity) {
        return gfhUsuarioJpaRepository.save(usuarioEntity);
    }

    @Override
    public int eliminarUsuario(int id) {
        gfhUsuarioJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public UsuarioEntity modificarUsuario(UsuarioEntity usuarioEntity) {
        gfhUsuarioJpaRepository.save(usuarioEntity);
        return null;
    }

    @Override
    public UsuarioEntity login (UsuarioDTO usuario) {
        return gfhUsuarioJpaRepository.findByEmailAndContrasenia(usuario.getEmail(), usuario.getContrasenia());
    }

    @Override
    public Optional<UsuarioEntity> findUsuarioById(int id) {
        return gfhUsuarioJpaRepository.findById(id);
    }

    @Override
    public List<UsuarioEntity> findUsuarioByRol(int id) {
        return gfhUsuarioJpaRepository.findByRol(id);
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

    @Override
    public UsuarioEntity casteoDTOaEntity(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new ModelMapper().map(usuarioDTO, UsuarioEntity.class);
        return usuarioEntity;
    }

    // :::::::::::::::::::::: MÉTODOS PARA EJERCICIOS :::::::::::::::::::::: //
    @Override
    public List<EjercicioEntity> listadoEjercicios() {
        return gfhEjercicioJpaRepository.findAll();
    }

    @Override
    public EjercicioEntity añadirEjercicio(EjercicioEntity ejercicioEntity) {
        return gfhEjercicioJpaRepository.save(ejercicioEntity);
    }

    @Override
    public int eliminarEjercicio(int id) {
        gfhEjercicioJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public EjercicioEntity modificarEjercicio(EjercicioEntity ejercicioEntity) {
        gfhEjercicioJpaRepository.save(ejercicioEntity);
        return null;
    }

    @Override
    public Optional<EjercicioEntity> findEjercicioById(int id) {
        return gfhEjercicioJpaRepository.findById(id);
    }


    // :::::::::::::::::::::: MÉTODOS PARA COMIDAS :::::::::::::::::::::: //
    @Override
    public List<ComidaEntity> listadoComida() {
        return gfhComidaJpaRepository.findAll();
    }

    @Override
    public ComidaEntity añadirComida(ComidaEntity comidaEntity) {
        return gfhComidaJpaRepository.save(comidaEntity);
    }

    @Override
    public int eliminarComida(int id) {
        gfhComidaJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public ComidaEntity modificarComida(ComidaEntity comidaEntity) {
        gfhComidaJpaRepository.save(comidaEntity);
        return null;
    }

    @Override
    public Optional<ComidaEntity> findComidaById(int id) {
        return gfhComidaJpaRepository.findById(id);
    }

    // :::::::::::::::::::::: MÉTODOS PARA TABLAS :::::::::::::::::::::: //
    @Override
    public List<TablaEntity> listadoTabla() {
        return null;
    }

    @Override
    public TablaEntity añadirTabla(TablaEntity tablaEntity) {
        return null;
    }

    @Override
    public int eliminarTabla(int id) {
        return 0;
    }

    @Override
    public TablaEntity modificarTabla(TablaEntity tablaEntity) {
        return null;
    }

    @Override
    public Optional<TablaEntity> findTablaById(int id) {
        return Optional.empty();
    }

    @Override
    public List<TablaEntity> findTablaByUsuarioId(int id) {
        return gfhTablaJpaRepository.findByUsuarioId_Id(id);
    }

}