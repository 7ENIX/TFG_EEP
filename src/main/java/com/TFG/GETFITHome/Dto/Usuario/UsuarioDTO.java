package com.TFG.GETFITHome.Dto.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private int rol = 1;
    @NotBlank(message = "Escribe tu nombre.")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "El nombre solo puede contener letras.")
    private String nombre;
    @NotBlank(message = "Escribe tu primer apellido.")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "El apellido solo puede contener letras.")
    private String apellido1;
    @NotBlank(message = "Escribe tu segundo apellido.")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "El apellido solo puede contener letras.")
    private String apellido2;
    @Email(message = "Escribe correctamente el email.")
    @NotBlank(message = "Escribe tu email.")
    private String email;
    @NotBlank(message = "Especifíca tu fecha de nacimiento.")
    private String fechaNacimiento;
    @Min(value = 0, message = "Indica cual es tu altura (sin calzado).")
    private double altura;
    @Min(value = 0, message = "Escribe tu peso")
    private double peso;
    @NotBlank(message = "Escribe aquí el número de cuenta donde se te cargará la mensualidad.")
    private String cuentaBancaria;
    @NotBlank(message = "Escribe qué contraseña quieres para tu cuenta.")
    private String contrasenia;

}



