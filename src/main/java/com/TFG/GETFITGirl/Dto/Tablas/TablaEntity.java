package com.TFG.GETFITGirl.Dto.Tablas;

import com.TFG.GETFITGirl.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITGirl.Dto.Usuario.UsuarioEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Tabla")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablaEntity {

    /**
     * NOTA: Esta clase no se refiere a una tabla de ejercicios, sino a un ejercicio
     * (cada uno de ellos) de la tabla de entrenamiento diário de los clientes.
     */


    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "UsuarioId", nullable = false)
    private UsuarioEntity usuarioId;
    @ManyToOne
    @JoinColumn(name = "EjercicioId", nullable = false)
    private EjercicioEntity ejercicioId;
    @Column(name = "Series")
    private int series;
    @Column(name = "Repeticiones")
    private int repeticiones;
    @Column(name = "Peso")
    private int peso;
    @Column(name = "Intensidad")
    private String intensidad;
    @Column(name = "Duracion")
    private String duracion;
    @Column(name = "Descanso")
    private String descanso;
}
