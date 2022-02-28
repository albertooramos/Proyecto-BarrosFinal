import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaEventoComponent } from './evento/lista-evento.component';
import { DetalleEventoComponent } from './evento/detalle-evento.component';
import { NuevoEventoComponent } from './evento/nuevo-evento.component';
import { EditarEventoComponent } from './evento/editar-evento.component';

const routes: Routes = [
  {path: '', component: ListaEventoComponent},
  {path: 'detalle/:idEvento', component: DetalleEventoComponent},
  {path: 'nuevo', component: NuevoEventoComponent},
  {path: 'editar/:idEvento', component: EditarEventoComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
