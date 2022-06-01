package com.TFG.GETFITHome.Dto.Comidas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComidaResponse {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    private String nombre;
    private String url;
}
