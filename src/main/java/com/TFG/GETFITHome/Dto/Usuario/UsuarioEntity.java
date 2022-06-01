package com.TFG.GETFITHome.Dto.Usuario;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    // ::::::::::::::::::::::: ATRIBUTOS ::::::::::::::::::::::: //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    @Column(name = "Rol", nullable = false)
    private int rol = 1;
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    @Column(name = "Primer_apellido", nullable = false)
    private String apellido1;
    @Column(name = "Segundo_apellido", nullable = false)
    private String apellido2;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "Fecha_de_Nacimiento", nullable = false)
    private String fechaNacimiento;
    @Column(name = "Altura", nullable = false)
    private double altura;
    @Column(name = "Peso", nullable = false)
    private double peso;
    @Column(name = "Numero_de_cuenta", nullable = false)
    private String cuentaBancaria;
    @Column(name = "Contrasenia", nullable = false)
    private String contrasenia;
}
