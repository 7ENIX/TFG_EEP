package com.TFG.GETFITGirl.Dto.Ejercicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    @NotBlank(message = "Escribe el nombre del ejercicio.")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+", message = "El nombre solo puede contener letras.")
    private String nombre;
    @NotBlank(message = "Escribe la zona de enfoque.")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+", message = "La zona solo puede contener letras.")
    private String zona;
    private String url;
}
