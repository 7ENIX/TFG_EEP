package com.TFG.GETFITGirl.Dto.Tablas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TablaDTO {

    /**
     * NOTA: Esta clase no se refiere a una tabla de ejercicios, sino a un ejercicio
     * (cada uno de ellos) de la tabla de entrenamiento diário de los clientes.
     */

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private int usuarioId;
    private int ejercicioId;
    private int series;
    private int repeticiones;
    private int peso;
    private String intensidad;
    private String duracion;
    @NotBlank(message = "Escribe el tiempo de descanso.")
    private String descanso;
}
