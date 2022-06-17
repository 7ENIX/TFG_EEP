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

    /**
     * Aquí localizamos los repositorios de métodos que utilizaremos para
     * que los métodos funcionen.
     */

    @Autowired
    private GFGUsuarioJpaRepository GFGUsuarioJpaRepository;

    @Autowired
    private GFGEjercicioJpaRepository GFGEjercicioJpaRepository;

    @Autowired
    private GFGComidaJpaRepository GFGComidaJpaRepository;

    @Autowired
    private GFGTablaJpaRepository GFGTablaJpaRepository;


    // :::::::::::::::::::::: MÉTODOS PARA USUARIOS :::::::::::::::::::::: //

    /**
     * Método que lee de la base de datos todos los usuarios registrados en la
     * aplicación con el atributo "rol = 1", los cuales son identificados como
     * clientes.
     * @return nos devuelve una Lista de "UsuarioEntity".
     */
    @Override
    public List<UsuarioEntity> listadoUsuarios() {
        return GFGUsuarioJpaRepository.findAll();
    }

    /**
     * Método que registra un nuevo usuario en la base de datos de la aplicación
     * cuando este se registra a través del login.
     * @param usuarioEntity Usuario para registrar en la BD.
     * @return Usuario registrado.
     */
    @Override
    public UsuarioEntity añadirUsuario(UsuarioEntity usuarioEntity) {
        return GFGUsuarioJpaRepository.save(usuarioEntity);
    }

    /**
     * Método que elimina a un usuario de la base de datos.
     * @param id Usamos el id (único) para localizar al usuario que queremos borrar.
     */
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

    /**
     * Método que utilizaremos para modificar los datos del usuario
     * cuando este esté mirando su perfil.
     * @param usuarioEntity El usuario que queremos modificar.
     * @return Usuario modificado guardado en la BD.
     */
    @Override
    public UsuarioEntity modificarUsuario(UsuarioEntity usuarioEntity) {
        return GFGUsuarioJpaRepository.save(usuarioEntity);
    }

    /**
     * Método que utilizamos para comparar el usuarioDTO que se introduce en el
     * login con el existente en la BD, para entrar en la aplicación. En caso de
     * no ser correcto, no entrará en la aplicación.
     * @param usuario UsuarioDTO que usa el método para comparar con el de la BD.
     * @return Nos retorna el usuario con el que hemos hecho el login.
     */
    @Override
    public UsuarioEntity login (UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = GFGUsuarioJpaRepository.findByEmailAndContrasenia(usuario.getEmail(), usuario.getContrasenia());
        return usuarioEntity;
    }

    /**
     * Método que encuentra a un usuario según su id (único).
     * @param id del usuario.
     * @return Nos retorna el usuario que buscamos.
     */
    @Override
    public UsuarioEntity findUsuarioById(int id) {
        return GFGUsuarioJpaRepository.getById(id);
    }

    /**
     * Método que nos encuentra a un usuario de la base de datos por el
     * campo de "rol". Esto lo utilizaremos más adelante para hacer un
     * listado de todos los usuarios con "rol = 1", los cuales son los
     * clientes.
     * @param id del usuario que queremos encontrar.
     * @return Lista de UsuarioEntity con "rol = 1"
     */
    @Override
    public List<UsuarioEntity> findUsuarioByRol(int id) {
        return GFGUsuarioJpaRepository.findByRol(id);
    }

    /**
     * Método por el cual validamos la edad del usuario que se quiere
     * registrar. Si no tiene, como mínimo 18 años, no podrá registrarse.
     * @param fecha introducida en el registro (nacimiento).
     * @return Si la edad del usuario es válida o no.
     */
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

    /**
     * Método que lista todos los ejercicios de la BD de la tabla
     * "Ejercicios".
     * @return Una lista de "EjercicioEntity".
     */
    @Override
    public List<EjercicioEntity> listadoEjercicios() {
        return GFGEjercicioJpaRepository.findAll();
    }

    /**
     * Método que registra un nuevo ejercicio en la BD.
     * @param ejercicioEntity introducido a registrar.
     * @return El ejercicio ya registrado.
     */
    @Override
    public EjercicioEntity añadirEjercicio(EjercicioEntity ejercicioEntity) {
        return GFGEjercicioJpaRepository.save(ejercicioEntity);
    }

    /**
     * Método que elimina un ejercicioEntity de la BD.
     * @param id del ejercicioEntity que queremos eliminar.
     */
    @Override
    public int eliminarEjercicio(int id) {
        GFGEjercicioJpaRepository.deleteById(id);
        return 0;
    }

    /**
     * Método que nos modifica los datos de un ejercicio de la tabla "Ejercicio".
     * @param ejercicioEntity El ejercicio que queremos modificar.
     */
    @Override
    public EjercicioEntity modificarEjercicio(EjercicioEntity ejercicioEntity) {
        GFGEjercicioJpaRepository.save(ejercicioEntity);
        return null;
    }

    /**
     * Método para encontrar un ejercicio por su id (único).
     * @param id el id del ejercicio que queremos utilizar.
     * @return Un ejercicioEntity.
     */
    @Override
    public EjercicioEntity findEjercicioById(int id) {
        return GFGEjercicioJpaRepository.getById(id);
    }


    // :::::::::::::::::::::: MÉTODOS PARA COMIDAS :::::::::::::::::::::: //

    /**
     * Método que lista todos las recetas de la BD de la tabla "Comidas".
     * @return Una lista de "ComidaEntity".
     */
    @Override
    public List<ComidaEntity> listadoComida() {
        return GFGComidaJpaRepository.findAll();
    }

    /**
     * Método que usamos para añadir una nueva comida a la tabla "Comidas".
     * @param comidaEntity introducida a registrar.
     * @return el objeto comidaEntity ya guardado.
     */
    @Override
    public ComidaEntity añadirComida(ComidaEntity comidaEntity) {
        return GFGComidaJpaRepository.save(comidaEntity);
    }

    /**
     * Método que usaremos para eliminar una comida de la tabla en la BD.
     * @param id del objeto que pasamos por argumentos para eliminarlo.
     */
    @Override
    public int eliminarComida(int id) {
        GFGComidaJpaRepository.deleteById(id);
        return 0;
    }

    /**
     * Método que modifica los el contenido de los atributos de un objeto comidaEntity.
     * @param comidaEntity el objeto que queremos que se modifique en la BD.
     * @return nos retorna el objeto ya modificado en la base de datos.
     */
    @Override
    public ComidaEntity modificarComida(ComidaEntity comidaEntity) {
        GFGComidaJpaRepository.save(comidaEntity);
        return null;
    }

    /**
     * Método para buscar un objeto de tipo ComidaEntity por su ID en la BD.
     * @param id del objeto que queremos que encuentre.
     * @return el objeto tipo ComidaEntity que buscamos.
     */
    @Override
    public Optional<ComidaEntity> findComidaById(int id) {
        return GFGComidaJpaRepository.findById(id);
    }

    // :::::::::::::::::::::: MÉTODOS PARA TABLAS :::::::::::::::::::::: //

    @Override
    public List<TablaEntity> listadoTabla(int id) {
        return GFGTablaJpaRepository.findByUsuarioId_Id(id);
    }

    /**
     * Método que añade un ejercicio a una tabla de entrenamiento de un cliente.
     * @param tablaEntity que le pasamos en el html para ser añadido.
     */
    @Override
    public TablaEntity añadirTabla(TablaEntity tablaEntity) {
        return GFGTablaJpaRepository.save(tablaEntity);
    }

    /**
     * Método que elimina un ejercicio de la tabla de entrenamiento de un cliente.
     * @param id el ID del objeto TablaENtity que queremos eliminar.
     */
    @Override
    public int eliminarTabla(int id) {
        GFGTablaJpaRepository.deleteById(id);
        return 0;
    }

    /**
     * Método que modifica uno, varios o todos los valores de los atributos de
     * un ejercicio tipo TablaEntity de la tabla de entrenamiento de un cliente.
     * @param tablaEntity
     * @return
     */
    @Override
    public TablaEntity modificarTabla(TablaEntity tablaEntity) {
        return GFGTablaJpaRepository.save(tablaEntity);
    }

    /**
     * Método que retorna un objeto tipo TablaEntity que buscamos en la BD
     * mediante su ID.
     * @param id del objeto tipo TablaEntity que queremos que encuentre.
     * @return el objeto que buscábamos.
     */
    @Override
    public TablaEntity findTablaById(int id) {
        return GFGTablaJpaRepository.getById(id);
    }

    /**
     * Método que busca una tabla de entrenamiento (una lista de objetos
     * tipo TablaEntity) que corresponde a un usuario "cliente" mediante
     * el ID de este.
     * @param id del usuario "cliente" que
     * @return La lista de entrenamiento del cliente X.
     */
    @Override
    public List<TablaEntity> findTablaByUsuarioId(int id) {
        return GFGTablaJpaRepository.findByUsuarioId_Id(id);
    }


    // :::::::::::::::::::::: MÉTODOS PARA CASTEAR :::::::::::::::::::::: //

    /**
     * Método que usamos para mapear un objeto de tipo UsuarioEntity a otro
     * de tipo UsuarioDTO con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param usuarioEntity que le pasamos como parámetro.
     * @return el objeto de tipo UsuarioDTO ya mapeado.
     */
    @Override
    public UsuarioDTO usuarioEntityaDTOMM(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new ModelMapper().map(usuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }

    /**
     * Método que usamos para mapear un objeto de tipo UsuarioDTO a otro
     * de tipo UsuarioEntity con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param usuarioDTO que le pasamos como parámetro.
     * @return el objeto de tipo UsuarioEntity ya mapeado.
     */
    @Override
    public UsuarioEntity usuarioDTOaEntityMM(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new ModelMapper().map(usuarioDTO, UsuarioEntity.class);
        return usuarioEntity;
    }

    /**
     * Método que usamos para mapear un objeto de tipo EjercicioEntity a otro
     * de tipo EjercicioDTO con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param ejercicioEntity que le pasamos como parámetro.
     * @return el objeto de tipo EjercicioDTO ya mapeado.
     */
    @Override
    public EjercicioDTO ejercicioEntityaDTOMM(EjercicioEntity ejercicioEntity) {
        EjercicioDTO ejercicioDTO = new ModelMapper().map(ejercicioEntity, EjercicioDTO.class);
        return ejercicioDTO;
    }

    /**
     * Método que usamos para mapear un objeto de tipo EjercicioDTO a otro
     * de tipo EjercicioEntity con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param ejercicioDTO que le pasamos como parámetro.
     * @return el objeto de tipo EjercicioEntity ya mapeado.
     */
    @Override
    public EjercicioEntity ejercicioDTOaEntityMM(EjercicioDTO ejercicioDTO) {
        EjercicioEntity ejercicioEntity = new ModelMapper().map(ejercicioDTO, EjercicioEntity.class);
        return ejercicioEntity;
    }

    /**
     * Método que usamos para mapear un objeto de tipo ComidaEntity a otro
     * de tipo ComidaDTO con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param comidaEntity que le pasamos como parámetro.
     * @return el objeto de tipo ComidaDTO ya mapeado.
     */
    @Override
    public ComidaDTO comidaEntityaDTOMM(ComidaEntity comidaEntity) {
        ComidaDTO comidaDTO = new ModelMapper().map(comidaEntity, ComidaDTO.class);
        return comidaDTO;
    }

    /**
     * Método que usamos para mapear un objeto de tipo ComidaDTO a otro
     * de tipo ComidaEntity con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param comidaDTO que le pasamos como parámetro.
     * @return el objeto de tipo ComidaEntity ya mapeado.
     */
    @Override
    public ComidaEntity comidaDTOaEntityMM(ComidaDTO comidaDTO) {
        ComidaEntity comidaEntity = new ModelMapper().map(comidaDTO, ComidaEntity.class);
        return comidaEntity;
    }

    /**
     * Método que usamos para mapear un objeto de tipo TablaEntity a otro
     * de tipo TablaDTO con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param tablaEntity que le pasamos como parámetro.
     * @return el objeto de tipo TablaDTO ya mapeado.
     */
    @Override
    public TablaDTO tablaEntityaDTOMM(TablaEntity tablaEntity) {
        TablaDTO tablaDTO = new ModelMapper().map(tablaEntity, TablaDTO.class);
        return tablaDTO;
    }

    /**
     * Método que usamos para mapear un objeto de tipo TablaDTO a otro
     * de tipo TablaEntity con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param tablaDTO que le pasamos como parámetro.
     * @return el objeto de tipo TablaEntity ya mapeado.
     */
    @Override
    public TablaEntity tablaDTOaEntityMM(TablaDTO tablaDTO) {
        TablaEntity tablaEntity = new ModelMapper().map(tablaDTO, TablaEntity.class);
        return tablaEntity;
    }

    /**
     * Método que usamos para mapear un objeto de tipo TablaEntity a otro
     * de tipo TablaResponse con los mismos valores en sus atributos.
     * La herramienta que usamos es ModelMapper.
     * @param tablaEntity que le pasamos como parámetro.
     * @return el objeto de tipo TablaResponse ya mapeado.
     */
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

    /**
     * Método que usamos para mapear una lista de objetos del tipo TablaEntity
     * a una lista de objetos de tipo TablaResponse.
     * La herramienta que usamos es ModelMapper.
     * @param lista que le pasamos por parámetro para mapear todos los objetos.
     * @return la lista con todos sus objetos mapeados.
     */
    @Override
    public List<TablaResponse> tablaEjercicios(List<TablaEntity> lista) {
        List<TablaResponse> tabla = new ArrayList<>();
        for (TablaEntity i: lista) {
            tabla.add(tablaEntityaResponse(i));
        }
        return tabla;
    }
}