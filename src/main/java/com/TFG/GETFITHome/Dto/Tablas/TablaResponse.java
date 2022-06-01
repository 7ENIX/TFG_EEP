package com.TFG.GETFITHome.Dto.Tablas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TablaResponse {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private String ejercicioNombre;
    private int series;
    private int repeticiones;
    private int peso;
    private String intensidad;
    private String duracion;
    private String descanso;
}



