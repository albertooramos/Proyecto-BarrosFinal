import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Evento } from '../models/evento';
import { EventoService } from '../service/evento.service';

@Component({
  selector: 'app-lista-evento',
  templateUrl: './lista-evento.component.html',
  styleUrls: ['./lista-evento.component.css']
})
export class ListaEventoComponent implements OnInit {

  eventos: Evento[]=[];

  public page: number;
  constructor(
    private eventoService: EventoService,
    private toastr: ToastrService,
    private router: Router

    ) { }

  ngOnInit() {
    this.cargarEventos();
  }

  cargarEventos(): void {
    this.eventoService.lista().subscribe(
      data => {
        this.eventos = data.content;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrar(idEvento: number) {
    this.eventoService.delete(idEvento).subscribe(
      data => {
        this.toastr.success('Evento Eliminado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
         window.location.reload();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        window.location.reload();
      }
    );
  }
}