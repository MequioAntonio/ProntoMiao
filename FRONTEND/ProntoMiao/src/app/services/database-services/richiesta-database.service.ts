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
    let result = this.dbs.http.get<Richiesta>(this.dbs.baseUrl+"/richiesta/"+id)

    return result
  }

  public insertRichiesta(richiesta: Richiesta){
    return this.dbs.http.post(this.dbs.baseUrl+"/richiesta", richiesta);
  }

  public getAllRichiesteByCentro(id_Centro: String): Observable<Richiesta[]>{
    let result = this.dbs.http.get<Richiesta[]>(this.dbs.baseUrl+"/richiesta/byCentro/"+id_Centro)
    return result
  }

  public getAllRichiesteByUtente(id_Utente: String): Observable<Richiesta[]>{
    let result = this.dbs.http.get<Richiesta[]>(this.dbs.baseUrl+"/richiesta/byUtente/"+id_Utente)
    return result
  }

}
