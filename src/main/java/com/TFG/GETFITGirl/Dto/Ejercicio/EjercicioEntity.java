package com.TFG.GETFITGirl.Dto.Ejercicio;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Ejercicio")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioEntity {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    @Column(name = "Nombre", nullable = false, unique = true)
    private String nombre;
    @Column(name = "Zona", nullable = false)
    private String zona;
    @Column(name = "Url")
    private String url;
}
