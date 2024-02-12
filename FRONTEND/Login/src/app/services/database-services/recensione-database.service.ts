import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Recensione } from '../../model/Recensione';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecensioneDatabaseService {

  constructor(private dbs: DatabaseService) {}

  public getAllRecensioni(): Observable<Recensione[]>{
    let result = this.dbs.http.get<Recensione[]>(this.dbs.baseUrl+"/recensione", {headers: this.dbs.headers})

    return result
  }

  public getRecensioneById(id: String): Observable<Recensione>{
    let result = this.dbs.http.get<Recensione>(this.dbs.baseUrl+"/recensione/"+id, {headers: this.dbs.headers})
    return result
  }

  public getAllRecensioniByCentro(id_Centro: String): Observable<Recensione[]>{
    let result = this.dbs.http.get<Recensione[]>(this.dbs.baseUrl+"/recensione/byCentro/"+id_Centro, {headers: this.dbs.headers})
    return result
  }
  public insertRecensione(recensione: any){
    return this.dbs.http.post(this.dbs.baseUrl+"/recensione", recensione, {headers: this.dbs.headers});
  }

  public deleteRecensioneById(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/recensione/"+id, {headers: this.dbs.headers})
  }

}
