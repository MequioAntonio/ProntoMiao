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

  public getAllAnimali(){
    this.dbs.http.get(this.dbs.baseUrl+"/animale").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public getAllAnimaliByNome(){
    this.dbs.http.get(this.dbs.baseUrl+"/animale/byNome").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
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
        this.dbs.http.post(this.dbs.baseUrl+"/animale/${id}", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteAnimale(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/animale/${id}")
  }

<<<<<<< HEAD
  public getAnimaleByID(id: String){
    this.dbs.http.get(this.dbs.baseUrl+"/animale/${id}").subscribe({
=======
  public static getAnimaleById(id: String){
    this.http.get(this.baseUrl+"/animale/${id}").subscribe({
>>>>>>> b1665da4fc2da9a1eb9c67e065644dec5363c79e
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }
}
