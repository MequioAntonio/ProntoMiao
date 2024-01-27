import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';

@Injectable({
  providedIn: 'root'
})
export class UtentePrivatoDatabaseService extends DatabaseService{

  constructor() { super(); }

  public static getAllUtentiPrivati(){
    this.http.get(this.baseUrl+"/utente").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

}
