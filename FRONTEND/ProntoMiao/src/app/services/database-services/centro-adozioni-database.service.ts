import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';

@Injectable({
  providedIn: 'root'
})
export class CentroAdozioniDatabaseService extends DatabaseService{

  constructor() { super(); }
  
  public static getAllCentriAdozioni(){
    this.http.get(this.baseUrl+"/centro-adozioni").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

}
