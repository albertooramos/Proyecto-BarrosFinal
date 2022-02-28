package com.jesuitas.Proyecto.Barros.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {
    private Integer idCliente;
    private String nombre;
    private Integer telefono;
    private String email;
    private String otrosDatos;
    private List eventos;


}
