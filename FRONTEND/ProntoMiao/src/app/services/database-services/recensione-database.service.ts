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
    let result = this.dbs.http.get<Recensione[]>(this.dbs.baseUrl+"/recensione")

    return result
  }

  public getRecensioneById(id: String): Observable<Recensione>{
    let result = this.dbs.http.get<Recensione>(this.dbs.baseUrl+"/recensione/${id}")
    return result
  }

  public getAllRecensioniByCentro(id_Centro: String): Observable<Recensione[]>{
    let result = this.dbs.http.get<Recensione[]>(this.dbs.baseUrl+"/recensione/byCentro/${id_Centro}")
    return result
  }

  public insertRecensione(recensione: Recensione){
    let observable: Observable<Recensione> = of(recensione)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/recensione", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteRecensioneById(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/recensione/${id}")
  }

}
