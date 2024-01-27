import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { UtentePrivato } from '../../model/UtentePrivato';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtentePrivatoDatabaseService{

  constructor(private dbs: DatabaseService) {}

  public getAllUtentiPrivati(): Observable<UtentePrivato[]>{
    let result = this.dbs.http.get<UtentePrivato[]>(this.dbs.baseUrl+"/utente")

    return result
  }

  public insertUtentePrivato(privato: UtentePrivato){
    let observable: Observable<UtentePrivato> = of(privato)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/utente", r)
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public updateUtentePrivato(id: String, privato: UtentePrivato){
    let observable: Observable<UtentePrivato> = of(privato)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/utente/${id}", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteAnimale(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/utente/${id}")
  }

  public getUserByID(id: String): Observable<UtentePrivato>{
    let result = this.dbs.http.get<UtentePrivato>(this.dbs.baseUrl+"/utente/${id}")

    return result
  }

  public getUserByEmail(email: String): Observable<UtentePrivato>{
    let result = this.dbs.http.get<UtentePrivato>(this.dbs.baseUrl+"/utente/${email}")


    return result
  }

}
