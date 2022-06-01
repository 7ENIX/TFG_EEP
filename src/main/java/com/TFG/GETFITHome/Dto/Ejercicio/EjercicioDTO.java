package com.TFG.GETFITHome.Dto.Ejercicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    @NotBlank(message = "Escribe el nombre del ejercicio.")
    private String nombre;
    @NotBlank(message = "Escribe la zona de enfoque.")
    private String zona;
    private String url;
}
