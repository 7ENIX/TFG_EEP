package com.TFG.GETFITHome.Dto.Ejercicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioResponse {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private String nombre;
    private String zona;
}
