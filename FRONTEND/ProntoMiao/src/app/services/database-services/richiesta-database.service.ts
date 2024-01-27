import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Richiesta } from '../../model/Richiesta';
import { Observable, of } from 'rxjs';

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

  public static getRichiestaById(id: String){
    this.http.get(this.baseUrl+"/richiesta/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static insertRichiesta(richiesta: Richiesta){
    let observable: Observable<Richiesta> = of(richiesta)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/richiesta", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

}
