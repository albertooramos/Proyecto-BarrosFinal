import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {NgxPaginationModule} from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaEventoComponent } from './evento/lista-evento.component';
import { DetalleEventoComponent } from './evento/detalle-evento.component';
import { NuevoEventoComponent } from './evento/nuevo-evento.component';
import { EditarEventoComponent } from './evento/editar-evento.component';

import { HttpClientModule} from '@angular/common/http';
import { FormsModule} from '@angular/forms';

//external1
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    ListaEventoComponent,
    DetalleEventoComponent,
    NuevoEventoComponent,
    EditarEventoComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
