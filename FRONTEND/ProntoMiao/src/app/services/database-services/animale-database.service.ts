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
    let result =  this.dbs.http.get<Animale[]>(this.dbs.baseUrl+"/animale?nome=&razza=&taglia=")

    console.log(result)
    console.log("result")

    return result
  }
  public getAllAnimaliNotAnnuncio(): Observable<Animale[]> {
    let result =  this.dbs.http.get<Animale[]>(this.dbs.baseUrl+"/animale/notAnnuncio")

    console.log(result)
    console.log("result")

    return result
  }

  public getAllAnimaliByNome(): Observable<Animale[]> {
    let result =  this.dbs.http.get<Animale[]>(this.dbs.baseUrl+"/animale/byNome")

    return result
  }

  public insertAnimale(animale: Animale){
    let observable: Observable<Animale> = of(animale)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/animale", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public updateAnimale(id: String, animale: Animale){
    let observable: Observable<Animale> = of(animale)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/animale/"+id, r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteAnimale(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/animale/"+id)
  }

  public getAnimaleByID(id: String): Observable<Animale> {
    let result = this.dbs.http.get<Animale>(this.dbs.baseUrl+"/animale/"+id)

    return result
  }
}
