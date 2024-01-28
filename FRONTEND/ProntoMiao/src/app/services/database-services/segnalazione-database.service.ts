import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Segnalazione } from '../../model/Segnalazione';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SegnalazioneDatabaseService{

  constructor(private dbs: DatabaseService) {}

  public getAllSegnalazioni(): Observable<Segnalazione[]>{
    let result = this.dbs.http.get<Segnalazione[]>(this.dbs.baseUrl+"/segnalazione")

    return result
  }

  public getSegnalazioneById(id: String): Observable<Segnalazione>{
    let result = this.dbs.http.get<Segnalazione>(this.dbs.baseUrl+"/segnalazione/"+id)

    return result
  }

  public insertSegnalazione(segnalazione: Segnalazione){
    let observable: Observable<Segnalazione> = of(segnalazione)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/segnalazione", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }
}
