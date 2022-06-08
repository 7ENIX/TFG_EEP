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
    @GetMapping("/")
    public String login(Model usuario) {
        usuario.addAttribute("usuario", new UsuarioDTO());
        return index_VIEW;
    }

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


    // :::::::::::::::::::::::::::::::::: REGISTRO ::::::::::::::::::::::::::::::::::: //
    @GetMapping("/registro")
    public String registro(Model cliente) {
        cliente.addAttribute("usuario", new UsuarioDTO());
        return registro_VIEW;
    }

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

    @GetMapping("/verPerfil/{id}")
    public String verPerfil(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("usuario", gfgServiceImpl.findUsuarioById(id));
        return verPerfil_VIEW;
    }

    @GetMapping("/modificarPerfil/{id}")
    public String modificarPerfil(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("usuario", gfgServiceImpl.findUsuarioById(id));
        return modificarPerfil_VIEW;
    }

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

    @GetMapping("/listaEjercicios")
    public String listaEjercicios(Model model) {
        model.addAttribute("listaEjercicios", gfgServiceImpl.listadoEjercicios());
        model.addAttribute("usuario", user);
        return listaEjercicios_VIEW;
    }

    @GetMapping("/listaComidas")
    public String listaComidas(Model model) {
        model.addAttribute("listaComidas", gfgServiceImpl.listadoComida());
        model.addAttribute("usuario", user);
        return listaComidas_VIEW;
    }

    @GetMapping("/verTabla/{id}")
    public String verTabla(Model model, @PathVariable(value = "id") int id) {
        idusuario = id;
        model.addAttribute("verTabla", gfgServiceImpl.tablaEjercicios(gfgServiceImpl.findTablaByUsuarioId(id)));
        model.addAttribute("usuarioSaludo", gfgServiceImpl.findUsuarioById(id));
        model.addAttribute("usuario", user);
        return tablaEjercicios_VIEW;
    }


    // :::::::::::::::::::::::::::::::::: CLIENTE :::::::::::::::::::::::::::::::::: //

    @GetMapping("/menuCliente")
    public String getMenuCliente_VIEW(Model usuarioModel){
        usuarioModel.addAttribute("usuarioSaludo", user);
        return menuCliente_VIEW;
    }


    // :::::::::::::::::::::::::::::::::: ENTRENADOR ::::::::::::::::::::::::::::::::::: //

    @GetMapping("/menuEntrenador")
    public String menuEntrenador(Model usuarioModel){
        usuarioModel.addAttribute("usuarioSaludo", user);
        return menuEntrenador_VIEW;
    }

    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model array) {
        array.addAttribute("listaUsuarios", gfgServiceImpl.findUsuarioByRol(1));
        return listaUsuarios_VIEW;
    }

    @GetMapping("/verPerfilCliente/{id}")
    public String verPerfilCliente (Model model, @PathVariable(value = "id") int id){
        model.addAttribute("usuario", gfgServiceImpl.findUsuarioById(id));
        return verPerfilCliente_VIEW;
    }


    // ----------------------------- AÑADIR: ----------------------------- //

    @GetMapping("/añadirEjercicio")
    public String añadirEjercicio(Model ejercicio) {
        ejercicio.addAttribute("ejercicio", new EjercicioDTO());
        return añadirEjercicio_VIEW;
    }

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

    @GetMapping("/añadirComida")
    public String añadirComida(Model comida) {
        comida.addAttribute("comida", new ComidaDTO());
        return añadirComida_VIEW;
    }

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

    @GetMapping("/añadirTabla/{id}")
    public String añadirTabla(@PathVariable(value = "id") int id, Model tabla) {
        tabla.addAttribute("tabla", new TablaDTO());
        tabla.addAttribute("id", id);
        tabla.addAttribute("listaEjercicios", gfgServiceImpl.listadoEjercicios());
        return añadirTabla_VIEW;
    }

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

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable(value = "id") int id) {
        gfgServiceImpl.eliminarUsuario(id);
        return "redirect:/listaUsuarios";
    }

    @GetMapping("/eliminarEjercicio/{id}")
    public String eliminarEjercicio(@PathVariable(value = "id") int id) {
        gfgServiceImpl.eliminarEjercicio(id);
        return "redirect:/listaEjercicios";
    }

    @GetMapping("/eliminarComida/{id}")
    public String eliminarComida(@PathVariable(value = "id") int id) {
        gfgServiceImpl.eliminarComida(id);
        return "redirect:/listaComidas";
    }

    @GetMapping("/eliminarTabla/{idtabla}")
    public String eliminarTabla(@PathVariable(value = "idtabla") int idtabla){
        gfgServiceImpl.eliminarTabla(idtabla);
        return "redirect:/verTabla/" + idusuario;
    }
}