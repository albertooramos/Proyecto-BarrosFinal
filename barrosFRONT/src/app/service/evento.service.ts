import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evento } from "../models/evento";

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  eventoURL= 'http://localhost:8081/evento/';
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<any>{
    return this.httpClient.get<any>(this.eventoURL + 'lista');
  }

  public detail(idEvento: number): Observable<Evento>{
    return this.httpClient.get<Evento>(this.eventoURL + "detail/" + idEvento);
  }

  public save(evento: Evento): Observable<any>{
    return this.httpClient.post<any>(this.eventoURL + "create", evento);
  }

  public update(idEvento: number, evento: Evento): Observable<any>{
    return this.httpClient.put<any>(this.eventoURL + 'update/' + idEvento, evento);
  }

  public delete(idEvento: number): Observable<any>{
    return this.httpClient.delete<any>(this.eventoURL + 'delete/' + idEvento);
  }

}
