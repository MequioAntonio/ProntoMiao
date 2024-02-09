import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Annuncio } from '../../model/Annuncio';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnnuncioDatabaseService {

  constructor(private dbs: DatabaseService) { }

  public getAllAnnunci(): Observable<Annuncio[]> {

    let result =  this.dbs.http.get<Annuncio[]>(this.dbs.baseUrl+"/annuncio", {headers: this.dbs.headers})

    return result
  }
  public getAllAnnunciNonAccettati(): Observable<Annuncio[]> {

    let result =  this.dbs.http.get<Annuncio[]>(this.dbs.baseUrl+"/annuncio/nonAccettati", {headers: this.dbs.headers})

    return result
  }

  public insertAnnuncio(annuncio: any){
    return this.dbs.http.post(this.dbs.baseUrl+"/annuncio", annuncio, {headers: this.dbs.headers});
  }

  public getAnnuncioByID(id: String): Observable<Annuncio> {
    let result = this.dbs.http.get<Annuncio>(this.dbs.baseUrl+"/annuncio/"+id, {headers: this.dbs.headers})
    return result
  }

  public getAllAnnunciByCentro(id_Centro: String): Observable<Annuncio[]> {
    return this.dbs.http.get<Annuncio[]>(this.dbs.baseUrl+"/annuncio/byCentro/"+id_Centro, {headers: this.dbs.headers})
  }
}
