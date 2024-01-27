import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

  public static getAllAnimali(){
    this.http.get(this.baseUrl+"/animale").subscribe({
      next:(r:any)=>{
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

  public static getAllAnnunci(){
    this.http.get(this.baseUrl+"/annuncio").subscribe({
      next:(r:any)=>{
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

  public static getAllCentriAdozioni(){
    this.http.get(this.baseUrl+"/centro-adozioni").subscribe({
      next:(r:any)=>{
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

  public static getAllRichieste(){
    this.http.get(this.baseUrl+"/richiesta").subscribe({
      next:(r:any)=>{
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

  public static getAllSegnalazioni(){
    this.http.get(this.baseUrl+"/segnalazione").subscribe({
      next:(r:any)=>{
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

  public static getAllUtentiPrivati(){
    this.http.get(this.baseUrl+"/utente").subscribe({
      next:(r:any)=>{
        console.log(r)
      },
      error:(e:any)=>{
        console.error(e);

      },
    })



  }

}
