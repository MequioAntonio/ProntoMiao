import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Animale } from '../../model/Animale';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnimaleDatabaseService extends DatabaseService{

  constructor() { super(); }

  public static getAllAnimali(){
    super.http.get(super.baseUrl+"/animale").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllAnimaliByNome(){
    this.http.get(this.baseUrl+"/animale/byNome").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static insertAnimale(animale: Animale){
    let observable: Observable<Animale> = of(animale)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/animale", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public static updateAnimale(id: String, animale: Animale){
    let observable: Observable<Animale> = of(animale)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/animale/${id}", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public static deleteAnimale(id: String){
    this.http.delete(this.baseUrl+"/animale/${id}")
  }

  public static getAnimaleByID(id: String){
    this.http.get(this.baseUrl+"/animale/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }
}
