import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Animale } from '../model/Animale';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  constructor() { }

  private static baseUrl = 'http://localhost:8080/';

  private static http: HttpClient

  public static getAllRecensioni(){
    this.http.get(this.baseUrl+"/recensione").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllAnimali(){
    this.http.get(this.baseUrl+"/animale").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllAnnunci(){
    this.http.get(this.baseUrl+"/annuncio").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllCentriAdozioni(){
    this.http.get(this.baseUrl+"/centro-adozioni").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllRichieste(){
    this.http.get(this.baseUrl+"/richiesta").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllSegnalazioni(){
    this.http.get(this.baseUrl+"/segnalazione").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllUtentiPrivati(){
    this.http.get(this.baseUrl+"/utente").subscribe({
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

  public static getAllAnimaliByID(id: String){
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
