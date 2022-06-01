package com.TFG.GETFITHome.Dto.Tablas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TablaDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private int usuarioId;
    @NotBlank(message = "Escribe el nombre del ejercicio.")
    private int ejercicioNombre;
    private int series;
    private int repeticiones;
    private int peso;
    private String intensidad;
    private String duracion;
    @NotBlank(message = "Escribe el tiempo de descanso.")
    private String descanso;
}
