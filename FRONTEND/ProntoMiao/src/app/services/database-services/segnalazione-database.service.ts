import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Segnalazione } from '../../model/Segnalazione';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SegnalazioneDatabaseService extends DatabaseService{

  constructor() { super(); }

  public static getAllSegnalazioni(){
    this.http.get(this.baseUrl+"/segnalazione").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getSegnalazioneById(id: String){
    this.http.get(this.baseUrl+"/segnalazione/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static insertSegnalazione(segnalazione: Segnalazione){
    let observable: Observable<Segnalazione> = of(segnalazione)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/segnalazione", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }
}
