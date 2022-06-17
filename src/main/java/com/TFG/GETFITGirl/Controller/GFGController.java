package com.TFG.GETFITGirl.Controller;

import com.TFG.GETFITGirl.Dto.Comidas.ComidaDTO;
import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioDTO;
import com.TFG.GETFITGirl.Dto.Tablas.TablaDTO;
import com.TFG.GETFITGirl.Dto.Usuario.UsuarioDTO;
import com.TFG.GETFITGirl.Dto.Usuario.UsuarioEntity;
import com.TFG.GETFITGirl.Service.GFGServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class GFGController {

    // Variables generales:
    private static final String index_VIEW = "index";
    private static final String pass_VIEW = "pass";
    private static final String terminosCondiciones_VIEW = "terminosCondiciones";
    private static final String politicaPrivacidad_VIEW = "politicaPrivacidad";
    private static final String listaEjercicios_VIEW = "listaEjercicios";
    private static final String listaComidas_VIEW = "listaComidas";
    private static final String tablaEjercicios_VIEW = "tablaEjercicios";
    private static final String verPerfil_VIEW = "verPerfil";
    private static final String modificarPerfil_VIEW = "modificarPerfil";

    // Variables clientes:
    private static final String registro_VIEW = "registro";
    private static final String menuCliente_VIEW = "menuCliente";

    // Variables entrenador:
    private static final String menuEntrenador_VIEW = "menuEntrenador";
    private static final String listaUsuarios_VIEW = "listaClientes";
    private static final String añadirEjercicio_VIEW = "añadirEjercicio";
    private static final String modificarEjercicio_VIEW = "modificarEjercicio";
    private static final String añadirComida_VIEW = "añadirComida";
    private static final String modificarComida_VIEW = "modificarComida";
    private static final String verPerfilCliente_VIEW = "verPerfilCliente";
    private static final String añadirTabla_VIEW = "añadirTabla";
    private static final String modificarTabla_VIEW = "modificarTabla";

    // Variable usuario:
    UsuarioEntity user = new UsuarioEntity();
    int idusuario = 0;

    @Autowired
    private GFGServiceImpl gfgServiceImpl;


    // ::::::::::::::::::::::::::::::::::: LOGIN ::::::::::::::::::::::::::::::::::: //

    /**
     * Controlador que utiliza un objeto de la clase UsuarioDTO para realizar el login.
     * @param usuario de la clase UsuarioDTO para acceder a la aplicación.
     * @return a la página por defecto de la aplicación, el login.
     */
    @GetMapping("/")
    public String login(Model usuario) {
        usuario.addAttribute("usuario", new UsuarioDTO());
        return index_VIEW;
    }

    /**
     * Controler "post" que, haciendo uso de un método de comprovación nos introducirá en la aplicación o no.
     * @param usuarioDTO necesario para el Login.
     * @return En el caso de que el usuario exista, nos dirige al menú del entrenador o del cliente. Por el contrario
     * nos devolverá al login.
     */
    @PostMapping("/loginOK")
    public String loginOK(@ModelAttribute("usuario") UsuarioDTO usuarioDTO, Model usuarioModel) {
        UsuarioEntity usuario = gfgServiceImpl.login(usuarioDTO);
        if (usuario == null) {
            return "redirect:/";
        } else {
            user = usuario;
            usuarioModel.addAttribute("usuarioSaludo", usuario);
            if (usuario.getRol() == 0) {
                return menuEntrenador_VIEW;
            } else {
                return menuCliente_VIEW;
            }
        }
    }
    // ::::::::::::::::::::::::::::: TÉRMINOS Y POLÍTICA ::::::::::::::::::::::::::::: //

    /**
     * Controler para la página de recuperación de contraseña (función no disponible).
     * @return Página de recuperación de contraseña.
     */
    @GetMapping("/pass")
    public String pass() {
        return pass_VIEW;
    }

    /**
     * Controler para ver los términos y condiciones de uso de la aplicación.
     * @return Página de términos y condiciones.
     */
    @GetMapping("/terminos")
    public String terminos() {
        return terminosCondiciones_VIEW;
    }

    /**
     * Controler para la consulta la política de privacidad de la aplicación.
     * @return Página de política de privacidad.
     */
    @GetMapping("/politica")
    public String politica() {
        return politicaPrivacidad_VIEW;
    }


    // :::::::::::::::::::::::::::::::::: REGISTRO ::::::::::::::::::::::::::::::::::: //

    /**
     * Controler para realizar el registro en la aplicación.
     * @param cliente Model necesario para ser registrado.
     * @return Página de registro.
     */
    @GetMapping("/registro")
    public String registro(Model cliente) {
        cliente.addAttribute("usuario", new UsuarioDTO());
        return registro_VIEW;
    }

    /**
     * Controler que, en caso de que el registro sea válido, nos redirige a la página de inicio para
     * poder hacer el login ahora que tenemos al usuario registrado. Uno de los métodos utilizados es
     * el de la comprovación de edad para el campo de fecha de nacimiento.
     * @param usuarioDTO necesario para ser registrado en la BD.
     * @param br Para la validación.
     * @param usuario Model necesario para el registro.
     * @return En caso de que el registro sea válido -> Página de inicio. Si no es válido -> Nos devuelve
     * a la página de registro con los mensajes de validación.
     */
    @PostMapping("/registro")
    public String registroOK(@Valid @ModelAttribute("usuario") UsuarioDTO usuarioDTO, BindingResult br, Model usuario) {
        if (br.hasErrors()) {
            usuario.addAttribute("usuario", usuarioDTO);
            return registro_VIEW;
        } else {
            Boolean mayor18 = gfgServiceImpl.validacionFechaNacimiento(usuarioDTO.getFechaNacimiento());
            if (mayor18) {
                gfgServiceImpl.añadirUsuario(gfgServiceImpl.usuarioDTOaEntityMM(usuarioDTO));
                return index_VIEW;
            } else {
                usuario.addAttribute("MensajeDeError", "Debes de tener 18 años o más para darte de alta.");
                return registro_VIEW;
            }
        }
    }


    // :::::::::::::::::::::::::::::::::: GENERALES :::::::::::::::::::::::::::::::::: //

    /**
     * Controler que nos lleva a la página del perfil de cada usuario.
     * @param model necesario para que se localice el cliente en la aplicación.
     * @param id necesario para localizar el perfil del usuario.
     * @return Página de perfil.
     */
    @GetMapping("/verPerfil/{id}")
    public String verPerfil(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("usuario", gfgServiceImpl.findUsuarioById(id));
        return verPerfil_VIEW;
    }

    /**
     * Controler para acceder a la modificación del perfil de cada usuario.
     * @param id necesario para localizar al usuario.
     * @return Página de modificación del perfil.
     */
    @GetMapping("/modificarPerfil/{id}")
    public String modificarPerfil(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("usuario", gfgServiceImpl.findUsuarioById(id));
        return modificarPerfil_VIEW;
    }

    /**
     * Controler que, en caso de que la modificación cumpla la validación, modificará los datos de
     * nuestro perfil.
     * @param usuarioDTO para actualizar en la BD.
     * @param br para la validación.
     * @param usuario necesario por el tema de Hibernate.
     * @return Si está bien -> página de perfil. Si está mal -> página de modificación de perfil
     * con mensajes de error en validación.
     */
    @PostMapping("/modificarPerfilOK")
    public String modificarPerfilOK(@Valid @ModelAttribute ("usuario") UsuarioDTO usuarioDTO, BindingResult br, Model usuario) {
        if (br.hasErrors()) {
            usuario.addAttribute("usuario", usuarioDTO);
            return modificarPerfil_VIEW;
        } else {
            user = gfgServiceImpl.modificarUsuario(gfgServiceImpl.usuarioDTOaEntityMM(usuarioDTO));
            return "redirect:/verPerfil/" + usuarioDTO.getId();
        }
    }

    /**
     * Controler que nos muestra una página con una lista de todos los ejercicios registrados en la BD.
     * @param model para mapear los ejercicios.
     * @return Página de lista de ejercicios.
     */
    @GetMapping("/listaEjercicios")
    public String listaEjercicios(Model model) {
        model.addAttribute("listaEjercicios", gfgServiceImpl.listadoEjercicios());
        model.addAttribute("usuario", user);
        return listaEjercicios_VIEW;
    }

    /**
     * Controler que nos muestra una página con una lista de todas las comidas registradas en la BD.
     * @param model para mapear las recetas.
     * @return Página para la lista de recetas.
     */
    @GetMapping("/listaComidas")
    public String listaComidas(Model model) {
        model.addAttribute("listaComidas", gfgServiceImpl.listadoComida());
        model.addAttribute("usuario", user);
        return listaComidas_VIEW;
    }

    /**
     * Controler que nos dirige a una página donde está el entrenamiento diario de cada Cliente.
     * @param model necesario para realizar la tabla.
     * @param id necesario para localizar la tabla de cada usuario con sus ejercicios.
     * @return Página de entrenamiento (lista de ejercicios diários) de cada cliente.
     */
    @GetMapping("/verTabla/{id}")
    public String verTabla(Model model, @PathVariable(value = "id") int id) {
        idusuario = id;
        model.addAttribute("verTabla", gfgServiceImpl.tablaEjercicios(gfgServiceImpl.findTablaByUsuarioId(id)));
        model.addAttribute("usuarioSaludo", gfgServiceImpl.findUsuarioById(id));
        model.addAttribute("usuario", user);
        return tablaEjercicios_VIEW;
    }


    // :::::::::::::::::::::::::::::::::: CLIENTE :::::::::::::::::::::::::::::::::: //

    /**
     * Controler para loguearnos como clientes y mostrarnos un menú con todas nuestra funcionalidades.
     * @param usuarioModel
     * @return Página de menú para los clientes.
     */
    @GetMapping("/menuCliente")
    public String getMenuCliente_VIEW(Model usuarioModel){
        usuarioModel.addAttribute("usuarioSaludo", user);
        return menuCliente_VIEW;
    }


    // :::::::::::::::::::::::::::::::::: ENTRENADOR ::::::::::::::::::::::::::::::::::: //

    /**
     * Controler para mostrar la página del menú de funcionalidades del entrenador cuando se loguea.
     * @param usuarioModel
     * @return Página de menú para el entrenador.
     */
    @GetMapping("/menuEntrenador")
    public String menuEntrenador(Model usuarioModel){
        usuarioModel.addAttribute("usuarioSaludo", user);
        return menuEntrenador_VIEW;
    }

    /**
     * Controler para mostrarnos una página con una lista de todos los usuarios de tipo cliente
     * registrados en la aplicación.
     * @param array para hacer la lista de clientes.
     * @return Página de listado de clientes.
     */
    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model array) {
        array.addAttribute("listaUsuarios", gfgServiceImpl.findUsuarioByRol(1));
        return listaUsuarios_VIEW;
    }

    /**
     * Controler que dirige al entrenador a la página de perfil de cada cliente para ver su información.
     * @param model
     * @param id del entrenador.
     * @return Página de perfil de "x" cliente vista desde el perfil del entrenador.
     */
    @GetMapping("/verPerfilCliente/{id}")
    public String verPerfilCliente (Model model, @PathVariable(value = "id") int id){
        model.addAttribute("usuario", gfgServiceImpl.findUsuarioById(id));
        return verPerfilCliente_VIEW;
    }


    // ----------------------------- AÑADIR: ----------------------------- //

    /**
     * Controler que nos lleva a una página de registro de un nuevo ejercicio.
     * @param ejercicio nuevo que va a ser registrado en al BD.
     * @return Página de registro de ejercicios.
     */
    @GetMapping("/añadirEjercicio")
    public String añadirEjercicio(Model ejercicio) {
        ejercicio.addAttribute("ejercicio", new EjercicioDTO());
        return añadirEjercicio_VIEW;
    }

    /**
     * Controler que registra un nuevo ejercicio en la base de datos.
     * @param ejercicioDTO Necesario para el registro.
     * @param br para la validación.
     * @return Si está bien -> Página de lista de ejercicios. Si no -> Página de registro de ejercicios
     * con mensajes de error de validación.
     */
    @PostMapping("/añadirEjercicioOK")
    public String añadirEjercicioOK(@Valid @ModelAttribute("ejercicio") EjercicioDTO ejercicioDTO, BindingResult br, Model ejercicio) {
        if (br.hasErrors()) {
            ejercicio.addAttribute("ejercicio", ejercicioDTO);
            return añadirEjercicio_VIEW;
        } else {
            gfgServiceImpl.añadirEjercicio(gfgServiceImpl.ejercicioDTOaEntityMM(ejercicioDTO));
            return "redirect:/listaEjercicios";
        }
    }

    /**
     * Controler que nos lleva a una página de registro de una nueva receta.
     * @param comida nueva que va a ser registrada en al BD.
     * @return Página de registro de recetas.
     */
    @GetMapping("/añadirComida")
    public String añadirComida(Model comida) {
        comida.addAttribute("comida", new ComidaDTO());
        return añadirComida_VIEW;
    }

    /**
     * Controler que registra una nueva receta en la base de datos.
     * @param comidaDTO Necesaria para el registro.
     * @param br para la validación.
     * @return Si está bien -> Página de lista de recetas. Si no -> Página de registro de recetas
     * con mensajes de error de validación.
     */
    @PostMapping("/añadirComidaOK")
    public String añadirComidaOK(@Valid @ModelAttribute("comida") ComidaDTO comidaDTO, BindingResult br, Model comida) {
        if (br.hasErrors()) {
            comida.addAttribute("comida", comidaDTO);
            return añadirComida_VIEW;
        } else {
            gfgServiceImpl.añadirComida(gfgServiceImpl.comidaDTOaEntityMM(comidaDTO));
            return "redirect:/listaComidas";
        }
    }

    /**
     * Controler que añade un ejercicio a una tabla de entrenamiento de "x" cliente.
     * @param id del usuario al que queremos editar la tabla.
     * @param tabla el ejercicio-tabla que se va a crear.
     * @return Página de registro de nuevo ejercicio en tabla de entrenamiento.
     */
    @GetMapping("/añadirTabla/{id}")
    public String añadirTabla(@PathVariable(value = "id") int id, Model tabla) {
        tabla.addAttribute("tabla", new TablaDTO());
        tabla.addAttribute("id", id);
        tabla.addAttribute("listaEjercicios", gfgServiceImpl.listadoEjercicios());
        return añadirTabla_VIEW;
    }

    /**
     * Controler que, si se registra bien, nos retorna a la tabla de entrenamiento del cliente. Si no,
     * nos devuelve al registro de un nuevo ejercicio-tabla.
     * @param tablaDTO que vamos a registrar.
     * @param br para la validación.
     * @param tabla el ejercicio-tabla que añadimos.
     * @return Página de entrenamiento diario de "x" cliente.
     */
    @PostMapping("/añadirTablaOK")
    public String añadirTablaOK(@Valid @ModelAttribute("tabla") TablaDTO tablaDTO, BindingResult br, Model tabla){
        if (br.hasErrors()) {
            tabla.addAttribute("comida", tablaDTO);
            return añadirTabla_VIEW;
        } else {
            gfgServiceImpl.añadirTabla(gfgServiceImpl.tablaDTOaEntityMM(tablaDTO));
            return "redirect:/listaUsuarios";
        }
    }

    // ----------------------------- MODIFICAR: ----------------------------- //
    /* Los siguientes controlers son como los de añadir de las clases anteriormente comentados. */

    @GetMapping("/modificarEjercicio/{id}")
    public String modificarEjercicio(@PathVariable(value = "id") int id, Model ejercicio){
        ejercicio.addAttribute("ejercicio", gfgServiceImpl.findEjercicioById(id));
        return modificarEjercicio_VIEW;
    }

    @PostMapping("/modificarEjercicioOK")
    public String modificarEjercicioOK(@Valid @ModelAttribute("ejercicio") EjercicioDTO ejercicioDTO, BindingResult br, Model ejercicio) {
        if (br.hasErrors()) {
            ejercicio.addAttribute("ejercicio", ejercicioDTO);
            return modificarEjercicio_VIEW;
        } else {
            gfgServiceImpl.modificarEjercicio(gfgServiceImpl.ejercicioDTOaEntityMM(ejercicioDTO));
            return "redirect:/listaEjercicios";
        }
    }

    @GetMapping("/modificarComida/{id}")
    public String modificarComida(@PathVariable(value = "id") int id, Model comida){
        comida.addAttribute("comida", gfgServiceImpl.findComidaById(id));
        return modificarComida_VIEW;
    }

    @PostMapping("/modificarComidaOK")
    public String modificarComidaOK(@Valid @ModelAttribute("comida") ComidaDTO comidaDTO, BindingResult br, Model comida) {
        if (br.hasErrors()) {
            comida.addAttribute("comida", comidaDTO);
            return modificarComida_VIEW;
        } else {
            gfgServiceImpl.modificarComida(gfgServiceImpl.comidaDTOaEntityMM(comidaDTO));
            return "redirect:/listaComidas";
        }
    }

    @GetMapping("/modificarTabla/{id}")
    public String modificarTabla(@PathVariable(value = "id") int id, Model tabla){
        tabla.addAttribute("tabla", gfgServiceImpl.tablaEntityaDTOMM(gfgServiceImpl.findTablaById(id)));
        tabla.addAttribute("idusuario", idusuario);
        return modificarTabla_VIEW;
    }

    @PostMapping("/modificarTablaOK")
    public String modificarTablaOK(@Valid @ModelAttribute("tabla") TablaDTO tablaDTO, BindingResult br, Model tabla) {
        if (br.hasErrors()) {
            tabla.addAttribute("tabla", tablaDTO);
            return modificarTabla_VIEW;
        } else {
            gfgServiceImpl.modificarTabla(gfgServiceImpl.tablaDTOaEntityMM(tablaDTO));
            return "redirect:/verTabla/" + idusuario;
        }
    }

    // ----------------------------- ELIMINAR: ----------------------------- //

    /**
     * Controler para eliminar un usuario de la BD.
     * @param id para localizar al usuario de tipo cliente en la BD.
     * @return Página de lista de clientes.
     */
    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable(value = "id") int id) {
        gfgServiceImpl.eliminarUsuario(id);
        return "redirect:/listaUsuarios";
    }

    /**
     * Controler para eliminar un ejercicio de la BD.
     * @param id para localizar el ejercicio en la BD.
     * @return Página de lista de ejercicios.
     */
    @GetMapping("/eliminarEjercicio/{id}")
    public String eliminarEjercicio(@PathVariable(value = "id") int id) {
        gfgServiceImpl.eliminarEjercicio(id);
        return "redirect:/listaEjercicios";
    }

    /**
     * Controler para eliminar una receta de la BD.
     * @param id para localizar la comida en la BD.
     * @return Página de lista de comidas/recetas.
     */
    @GetMapping("/eliminarComida/{id}")
    public String eliminarComida(@PathVariable(value = "id") int id) {
        gfgServiceImpl.eliminarComida(id);
        return "redirect:/listaComidas";
    }

    /**
     * Controler para eliminar un ejercicio de una tabla de entrenamiento de un cliente en la BD.
     * @param idtabla  para localizar el ejercicio de la tabla en la BD.
     * @return Página de lista de entrenamiento de "x" cliente.
     */
    @GetMapping("/eliminarTabla/{idtabla}")
    public String eliminarTabla(@PathVariable(value = "idtabla") int idtabla){
        gfgServiceImpl.eliminarTabla(idtabla);
        return "redirect:/verTabla/" + idusuario;
    }
}