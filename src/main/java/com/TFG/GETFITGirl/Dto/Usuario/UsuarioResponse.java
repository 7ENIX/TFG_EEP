package com.TFG.GETFITGirl.Dto.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private int rol = 1;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String fechaNacimiento;
    private double altura;
    private double peso;
    private String cuentaBancaria;
    private String contrasenia;
}
