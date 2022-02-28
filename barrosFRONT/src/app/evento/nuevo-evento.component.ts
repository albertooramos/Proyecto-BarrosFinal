import { Component, OnInit } from '@angular/core';
import { EventoService } from '../service/evento.service';
import { Evento } from '../models/evento';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-evento',
  templateUrl: './nuevo-evento.component.html',
  styleUrls: ['./nuevo-evento.component.css']
})
export class NuevoEventoComponent implements OnInit {
  idEvento=0;
  tipoEvento= '';
  fecha=new Date();
  horaInicio=new Date();
  horaFin=new Date();
  comidaCena=false;
  salon='';
  numeroComensales=0;
  numeroContratoAsociado=0;
  menu='';
  menuInfantil='';
  menuEspecial='';
  planos='';
  dj='';
  musicaSalon='';
  musicaAperitivo='';
  musicaBaile='';
  barraLibre='';
  flores='';
  ceremoniaBarros=false;
  Autobuses='';
  bonoAutobus=false;
  bonoHotel=false;
  vinos='';
  cava ='';
  rincones='';
  decoracion='';
  notas='';



  constructor(
    private eventoService: EventoService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  onCreate(): void {
    const evento = new Evento(this.tipoEvento, this.fecha, this.horaInicio, this.horaFin, this.comidaCena, this.salon, this.numeroComensales, this.numeroContratoAsociado, this.menu, this.menuInfantil, this.menuEspecial, this.planos, this.dj, this.musicaSalon, this.musicaAperitivo, this.musicaBaile, this.barraLibre, this.flores, this.ceremoniaBarros, this.Autobuses, this.bonoAutobus, this.bonoHotel, this.vinos, this.cava, this.rincones, this.decoracion, this.notas);
    this.eventoService.save(evento).subscribe(
      data => {
        this.toastr.success('Evento Creado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
    );
  }

}