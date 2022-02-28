export class Evento {
    idEvento?: number;
    tipoEvento: string;
    fecha: Date;
    horaInicio: Date;
    horaFin: Date;
    comidaCena: Boolean;
    salon: string;
    numeroComensales: number;
    numeroContratoAsociado: number;
    menu: string;
    menuInfantil: string;
    menuEspecial: string;
    planos: string;
    dj: string;
    musicaSalon: string;
    musicaAperitivo: string;
    musicaBaile: string;
    barraLibre: string;
    flores: string;
    ceremoniaBarros: Boolean;
    Autobuses: string ;
    bonoAutobus: Boolean;
    bonoHotel: Boolean;
    vinos: string;
    cava: string;
    rincones: string;
    decoracion: string;
    notas: string;

    constructor(tipoEvento: string, fecha: Date, horaInicio: Date, horaFin: Date, comidaCena: Boolean,salon: string, numeroComensales: number, numeroContratoAsociado: number,menu: string, menuInfantil: string,menuEspecial: string,planos: string,dj: string,musicaSalon: string,musicaAperitivo: string,musicaBaile: string,barraLibre: string,flores: string,ceremoniaBarros: Boolean,Autobuses: string ,bonoAutobus: Boolean,bonoHotel: Boolean,vinos: string,cava: string,rincones: string,decoracion: string, notas: string){
        this.tipoEvento=tipoEvento;
        this.fecha=fecha;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.comidaCena=comidaCena;
        this.salon=salon;
        this.numeroComensales=numeroComensales;
        this.numeroContratoAsociado=numeroContratoAsociado;
        this.menu=menu;
        this.menuInfantil=menuInfantil;
        this.menuEspecial=menuEspecial;
        this.planos=planos;
        this.dj=dj;
        this.musicaSalon=musicaSalon;
        this.musicaAperitivo=musicaAperitivo;
        this.musicaBaile=musicaBaile;
        this.barraLibre=barraLibre;
        this.flores=flores;
        this.ceremoniaBarros=ceremoniaBarros;
        this.Autobuses=Autobuses;
        this.bonoAutobus=bonoAutobus;
        this.bonoHotel=bonoHotel;
        this.vinos=vinos;
        this.cava=cava;
        this.rincones=rincones;
        this.decoracion=decoracion;
        this.notas=notas;
}

}