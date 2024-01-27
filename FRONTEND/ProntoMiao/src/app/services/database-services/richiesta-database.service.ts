import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Richiesta } from '../../model/Richiesta';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RichiestaDatabaseService{

  constructor(private dbs: DatabaseService) {}

  public getAllRichieste(): Observable<Richiesta[]>{
    let result = this.dbs.http.get<Richiesta[]>(this.dbs.baseUrl+"/richiesta")

    return result
  }

  public getRichiestaById(id: String): Observable<Richiesta>{
    let result = this.dbs.http.get<Richiesta>(this.dbs.baseUrl+"/richiesta/${id}")

    return result
  }

  public insertRichiesta(richiesta: Richiesta){
    let observable: Observable<Richiesta> = of(richiesta)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/richiesta", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

}
