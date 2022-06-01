package com.TFG.GETFITHome.Controller;

import com.TFG.GETFITHome.Dto.Usuario.UsuarioDTO;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioEntity;
import com.TFG.GETFITHome.Service.GFHServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class GFHController {

    // Variables generales:
    private static final String index_VIEW = "index";
    private static final String listaEjercicios_VIEW = "listaEjercicios";
    private static final String listaComidas_VIEW = "listaComidas";
    private static final String tablaEjercicios_VIEW = "tablaEjercicios";

    // Variables clientes:
    private static final String registro_VIEW = "registro";
    private static final String menuCliente_VIEW = "menuCliente";

    // Variables entrenador:
    private static final String menuEntrenador_VIEW = "menuEntrenador";
    private static final String listaUsuarios_VIEW = "listaClientes";
    private static final String fail_VIEW = "fail";

    // Variable usuario:
    UsuarioEntity user = new UsuarioEntity();

    @Autowired
    private GFHServiceImpl gfhServiceImpl;


    // ::::::::::::::::::::::::::::::::::: LOGIN ::::::::::::::::::::::::::::::::::: //
    @GetMapping("/")
    public String login(Model usuario) {
        usuario.addAttribute("usuario", new UsuarioDTO());
        return index_VIEW;
    }

    @PostMapping("/")
    public String loginOK(@ModelAttribute("usuario") UsuarioDTO usuarioDTO, Model usuarioModel) {
        UsuarioEntity usuario = gfhServiceImpl.login(usuarioDTO);
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
            Boolean mayor18 = gfhServiceImpl.validacionFechaNacimiento(usuarioDTO.getFechaNacimiento());
            if(mayor18){
                gfhServiceImpl.añadirUsuario(gfhServiceImpl.casteoDTOaEntity(usuarioDTO));
                return index_VIEW;

            } else {
                usuario.addAttribute("MensajeDeError", "Debes de tener 18 años o más para darte de alta.");
                return registro_VIEW;
            }
        }
    }


    // :::::::::::::::::::::::::::::::::: GENERALES ::::::::::::::::::::::::::::::::::: //
    @GetMapping("/listaEjercicios")
    public String listaEjercicios(Model model){
        model.addAttribute("listaEjercicios", gfhServiceImpl.listadoEjercicios());
        model.addAttribute("usuario", user);
        return listaEjercicios_VIEW;
    }

    @GetMapping("/listaComidas")
    public String listaComidas(Model model){
        model.addAttribute("listaComidas", gfhServiceImpl.listadoComida());
        model.addAttribute("usuario", user);
        return listaComidas_VIEW;
    }

    @GetMapping("/verTabla/{id}")
    public String verTabla(Model model, @PathVariable (value = "id") int id){
        model.addAttribute("verTabla", gfhServiceImpl.findTablaByUsuarioId(id));
        model.addAttribute("usuario", user);
        return tablaEjercicios_VIEW;
    }


    // :::::::::::::::::::::::::::::::::: ENTRENADOR ::::::::::::::::::::::::::::::::::: //
    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model array){
        array.addAttribute("listaUsuarios", gfhServiceImpl.findUsuarioByRol(1));
        return listaUsuarios_VIEW;
    }

    @GetMapping("/crearEditarTablaCliente")
    public String crearEditarTablaCliente(){
        //--------------------------------------//
        return fail_VIEW;
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable(value = "id") int id) {
        gfhServiceImpl.eliminarUsuario(id);
        return "redirect:/listaUsuarios";
    }

    @GetMapping("/eliminarEjercicio/{id}")
    public String eliminarEjercicio(@PathVariable(value = "id") int id) {
        gfhServiceImpl.eliminarEjercicio(id);
        return "redirect:/listaEjercicios";
    }

    @GetMapping("/eliminarComida/{id}")
    public String eliminarComida(@PathVariable(value = "id") int id) {
        gfhServiceImpl.eliminarComida(id);
        return "redirect:/listaComidas";
    }
}
