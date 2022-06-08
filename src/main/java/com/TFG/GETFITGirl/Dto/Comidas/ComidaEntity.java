package com.TFG.GETFITGirl.Dto.Comidas;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Comida")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComidaEntity {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    @Column(name = "Nombre", nullable = false, unique = true)
    private String nombre;
    @Column(name = "Url", unique = true)
    private String url;
}
