package com.TFG.GETFITGirl.Dto.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private int rol = 1;
    @NotBlank(message = "Escribe tu nombre.")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+", message = "El nombre solo puede contener letras.")
    private String nombre;
    @NotBlank(message = "Escribe tu primer apellido.")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+", message = "El apellido solo puede contener letras.")
    private String apellido1;
    @NotBlank(message = "Escribe tu segundo apellido.")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+", message = "El apellido solo puede contener letras.")
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
    @Pattern(regexp = "[a-zA-ZÀ-ÿ0-9\\u00f1\\u00d1]+", message = "La contraseña no puede tener espacios.")
    private String contrasenia;
}



