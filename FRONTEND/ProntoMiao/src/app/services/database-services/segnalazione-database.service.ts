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
    let result = this.dbs.http.get<Segnalazione[]>(this.dbs.baseUrl+"/segnalazione", {headers: this.dbs.headers})

    return result
  }

  public getSegnalazioneById(id: String): Observable<Segnalazione>{
    let result = this.dbs.http.get<Segnalazione>(this.dbs.baseUrl+"/segnalazione/"+id, {headers: this.dbs.headers})

    return result
  }

  public insertSegnalazione(segnalazione: Segnalazione){
    let observable: Observable<Segnalazione> = of(segnalazione)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/segnalazione", r, {headers: this.dbs.headers})
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }
}
