import { Component, OnInit } from '@angular/core';
import { Evento } from '../models/evento';
import { EventoService } from '../service/evento.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-editar-evento',
  templateUrl: './editar-evento.component.html',
  styleUrls: ['./editar-evento.component.css']
})
export class EditarEventoComponent implements OnInit {
  
  
  evento: Evento = null;
  


  constructor(
    private eventoService: EventoService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router 
  ) { }

  ngOnInit() {
    const idEvento = this.activatedRoute.snapshot.params['idEvento'];
    this.eventoService.detail(idEvento).subscribe(
      data => {
        this.evento = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
    );
  }

  onUpdate(): void {
    const idEvento = this.activatedRoute.snapshot.params['idEvento'];
    this.eventoService.update(idEvento, this.evento).subscribe(
      data => {
        this.toastr.success('Evento Actualizado', 'OK', {
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
