import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';

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

}
