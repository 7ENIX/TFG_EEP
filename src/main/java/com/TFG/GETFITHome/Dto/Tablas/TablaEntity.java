package com.TFG.GETFITHome.Dto.Tablas;

import com.TFG.GETFITHome.Dto.Ejercicio.EjercicioEntity;
import com.TFG.GETFITHome.Dto.Usuario.UsuarioEntity;
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
