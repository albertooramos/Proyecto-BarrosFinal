package com.jesuitas.Proyecto.Barros.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Evento")
@Data
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private Integer idEvento;

    @NonNull
    @Column(name = "TIPO_EVENTO")
    private String tipoEvento;

    @NonNull
    @Column(name = "FECHA")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecha;

    @NonNull
    @Column(name = "HORA_INICIO")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaInicio;

    @NonNull
    @Column(name = "HORA_FIN")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaFin;

    @NonNull
    @Column(name = "COMIDA_CENA")
    private Boolean comidaCena;

    @NonNull
    @Column(name = "SALON")
    private String salon;

    @NonNull
    @Column(name = "NUMERO_COMENSALES")
    private Integer numeroComensales;

    @NonNull
    @Column(name = "NUMERO_CONTRATO_ASOCIADO")
    private Integer numeroContratoAsociado;

    @NonNull
    @Column(name = "MENU")
    private String menu;

    @NonNull
    @Column(name = "MENU_INFANTIL")
    private String menuInfantil;

    @Column(name = "MENU_ESPECIAL")
    private String menuEspecial;

    @NonNull
    @Column(name = "PLANOS")
    private String planos;

    @Column(name = "DJ")
    private String dj;

    @Column(name = "MUSICA_SALON")
    private String musicaSalon;

    @Column(name = "MUSICA_APERITIVO")
    private String musicaAperitivo;

    @Column(name = "MUSICA_BAILE")
    private String musicaBaile;

    @Column(name = "BARRA_LIBRE")
    private String barraLibre;

    @Column(name = "FLORES")
    private String flores;

    @Column(name = "CEREMONIA_BARROS")
    private Boolean ceremoniaBarros;

    @Column(name = "AUTOBUSES")
    private String Autobuses;

    @Column(name = "BONO_AUTOBUS")
    private Boolean bonoAutobus;

    @Column(name = "BONO_HOTEL")
    private Boolean bonoHotel;

    @Column(name = "VINOS")
    private String vinos;

    @Column(name = "CAVA")
    private String cava;

    @Column(name = "RINCONES")
    private String rincones;

    @Column(name = "DECORACION")
    private String decoracion;

    @Column(name = "NOTAS")
    private String notas;

    public Evento(@NonNull String tipoEvento, @NonNull Date fecha, @NonNull Date horaInicio, @NonNull Date horaFin, @NonNull Boolean comidaCena, @NonNull String salon, @NonNull Integer numeroComensales, @NonNull Integer numeroContratoAsociado, @NonNull String menu, @NonNull String menuInfantil, String menuEspecial, @NonNull String planos, String dj, String musicaSalon, String musicaAperitivo, String musicaBaile, String barraLibre, String flores, Boolean ceremoniaBarros, String autobuses, Boolean bonoAutobus, Boolean bonoHotel, String vinos, String cava, String rincones, String decoracion, String notas, List<Cliente> clientes) {
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.comidaCena = comidaCena;
        this.salon = salon;
        this.numeroComensales = numeroComensales;
        this.numeroContratoAsociado = numeroContratoAsociado;
        this.menu = menu;
        this.menuInfantil = menuInfantil;
        this.menuEspecial = menuEspecial;
        this.planos = planos;
        this.dj = dj;
        this.musicaSalon = musicaSalon;
        this.musicaAperitivo = musicaAperitivo;
        this.musicaBaile = musicaBaile;
        this.barraLibre = barraLibre;
        this.flores = flores;
        this.ceremoniaBarros = ceremoniaBarros;
        this.Autobuses = autobuses;
        this.bonoAutobus = bonoAutobus;
        this.bonoHotel = bonoHotel;
        this.vinos = vinos;
        this.cava = cava;
        this.rincones = rincones;
        this.decoracion = decoracion;
        this.notas = notas;
        this.clientes = clientes;
    }


    @JoinTable(
            name = "eventos_clientes",schema = "public",
            joinColumns = @JoinColumn(name = "idEvento",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "idCliente",nullable=false))
    @ManyToMany
    private List<Cliente> clientes;


}
