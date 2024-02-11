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
    let result = this.dbs.http.get<Richiesta[]>(this.dbs.baseUrl+"/richiesta", {headers: this.dbs.headers})

    return result
  }

  public getRichiestaById(id: String): Observable<Richiesta>{
    let result = this.dbs.http.get<Richiesta>(this.dbs.baseUrl+"/richiesta/"+id, {headers: this.dbs.headers})

    return result
  }

  public insertRichiesta(richiesta: any){
    return this.dbs.http.post(this.dbs.baseUrl+"/richiesta", richiesta, {headers: this.dbs.headers});
  }

  public getAllRichiesteByCentro(id_Centro: String): Observable<Richiesta[]>{
    let result = this.dbs.http.get<Richiesta[]>(this.dbs.baseUrl+"/richiesta/byCentro/"+id_Centro, {headers: this.dbs.headers})
    return result
  }

  public getAllRichiesteByUtente(id_Utente: String): Observable<Richiesta[]>{
    let result = this.dbs.http.get<Richiesta[]>(this.dbs.baseUrl+"/richiesta/byUtente/"+id_Utente)
    return result
  }

  public updateRichiesta(id: Number, richiesta: any){
    return this.dbs.http.post(this.dbs.baseUrl+"/richiesta/"+id, richiesta, {headers: this.dbs.headers});
  }

}
