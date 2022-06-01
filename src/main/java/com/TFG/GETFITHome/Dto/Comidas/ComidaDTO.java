package com.TFG.GETFITHome.Dto.Comidas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComidaDTO {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    private int id;
    @NotBlank(message = "Escribe el nombre de la receta.")
    private String nombre;
    private String url;
}
