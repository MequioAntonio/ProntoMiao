import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';

@Injectable({
  providedIn: 'root'
})
export class RichiestaDatabaseService extends DatabaseService{

  constructor() { super(); }

  public static getAllRichieste(){
    this.http.get(this.baseUrl+"/richiesta").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

}
