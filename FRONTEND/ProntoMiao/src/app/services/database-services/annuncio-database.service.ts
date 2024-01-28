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

    let result =  this.dbs.http.get<Annuncio[]>(this.dbs.baseUrl+"/annuncio")

    return result
  }

  public insertAnnuncio(annuncio: Annuncio){
    let observable: Observable<Annuncio> = of(annuncio)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/annuncio", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public getAnnuncioByID(id: String): Observable<Annuncio> {
    let result = this.dbs.http.get<Annuncio>(this.dbs.baseUrl+"/annuncio/"+id)
    return result
  }

  public getAllAnnunciByCentro(id_Centro: String): Observable<Annuncio[]> {
    return this.dbs.http.get<Annuncio[]>(this.dbs.baseUrl+"/annuncio/byCentro/"+id_Centro)
  }
}
