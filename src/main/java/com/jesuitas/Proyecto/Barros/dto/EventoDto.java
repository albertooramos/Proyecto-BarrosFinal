package com.jesuitas.Proyecto.Barros.dto;

import com.jesuitas.Proyecto.Barros.domain.Cliente;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
public class EventoDto {

    private Integer idEvento;
    private String tipoEvento;
    private Date fecha;
    private Date horaInicio;
    private Date horaFin;
    private Boolean comidaCena;
    private String salon;
    private Integer numeroComensales;
    private Integer numeroContratoAsociado;
    private String menu;
    private String menuInfantil;
    private String menuEspecial;
    private String planos;
    private String dj;
    private String musicaSalon;
    private String musicaAperitivo;
    private String musicaBaile;
    private String barraLibre;
    private String flores;
    private Boolean ceremoniaBarros;
    private String Autobuses;
    private Boolean bonoAutobus;
    private Boolean bonoHotel;
    private String vinos;
    private String cava;
    private String rincones;
    private String decoracion;
    private String notas;
    private List<Cliente> clientes;
}
