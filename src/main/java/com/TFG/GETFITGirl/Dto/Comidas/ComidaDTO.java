package com.TFG.GETFITGirl.Dto.Comidas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComidaDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    @NotBlank(message = "Escribe el nombre de la receta.")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+", message = "El nombre solo puede contener letras.")
    private String nombre;
    private String url;
}
