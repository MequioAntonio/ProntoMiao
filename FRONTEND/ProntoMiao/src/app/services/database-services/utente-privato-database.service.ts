import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { UtentePrivato } from '../../model/UtentePrivato';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtentePrivatoDatabaseService extends DatabaseService{

  constructor() { super(); }

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

  public static insertUtentePrivato(privato: UtentePrivato){
    let observable: Observable<UtentePrivato> = of(privato)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/utente", r)
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static updateUtentePrivato(id: String, privato: UtentePrivato){
    let observable: Observable<UtentePrivato> = of(privato)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/utente/${id}", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public static deleteAnimale(id: String){
    this.http.delete(this.baseUrl+"/utente/${id}")
  }

  public static getUserByID(id: String){
    this.http.get(this.baseUrl+"/utente/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getUserByEmail(email: String){
    this.http.get(this.baseUrl+"/utente/${email}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

}
