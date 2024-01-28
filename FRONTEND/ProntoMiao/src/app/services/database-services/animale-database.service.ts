import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Animale } from '../../model/Animale';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnimaleDatabaseService{

  constructor(private dbs: DatabaseService) { }


  public getAllAnimali(): Observable<Animale[]> {
    let result =  this.dbs.http.get<Animale[]>(this.dbs.baseUrl+"/animale?nome=&razza=&taglia=", {headers: this.dbs.headers})

    return result
  }
  public getAllAnimaliNotAnnuncio(): Observable<Animale[]> {
    let result =  this.dbs.http.get<Animale[]>(this.dbs.baseUrl+"/animale/notAnnuncio")

    console.log(result)
    console.log("result")

    return result
  }

  public getAllAnimaliByNome(): Observable<Animale[]> {
    let result =  this.dbs.http.get<Animale[]>(this.dbs.baseUrl+"/animale/byNome", {headers: this.dbs.headers})

    return result
  }

  public insertAnimale(animale: Animale){
    return this.dbs.http.post(this.dbs.baseUrl+"/animale", animale, {headers: this.dbs.headers});
  }

  public updateAnimale(id: String, animale: Animale){
    let observable: Observable<Animale> = of(animale)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/animale/"+id, r, {headers: this.dbs.headers})
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteAnimale(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/animale/"+id, {headers: this.dbs.headers})
  }

  public getAnimaleByID(id: String): Observable<Animale> {
    let result = this.dbs.http.get<Animale>(this.dbs.baseUrl+"/animale/"+id, {headers: this.dbs.headers})

    return result
  }
}
