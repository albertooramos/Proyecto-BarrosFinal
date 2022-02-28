package com.jesuitas.Proyecto.Barros.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cliente")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @NonNull
    @Column(name = "NOMBRE")
    private String nombre;

    @NonNull
    @Column(name = "TELEFONO")
    private Integer telefono;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "OTROS_DATOS")
    private String otrosDatos;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany (mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Evento> eventos;

    public Cliente(@NonNull String nombre, @NonNull Integer telefono, String email, String otrosDatos) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.otrosDatos = otrosDatos;
    }
}
