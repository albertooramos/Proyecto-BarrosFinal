package com.jesuitas.Proyecto.Barros.domain;

import lombok.AllArgsConstructor;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @NonNull
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @NonNull
    @Column(name = "CONTRASENIA")
    private String contrasenia;

    public Usuario(Integer idUsuario, @NonNull String nombreUsuario, @NonNull String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
}
