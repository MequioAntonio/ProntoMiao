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
    let result = this.dbs.http.get<UtentePrivato[]>(this.dbs.baseUrl+"/utente", {headers: this.dbs.headers})

    return result
  }

  public insertUtentePrivato(privato: any){
    return this.dbs.http.post(this.dbs.baseUrl+"/utente", privato, {headers: this.dbs.headers});
  }

  public updateUtentePrivato(id: String, privato: UtentePrivato){
    let observable: Observable<UtentePrivato> = of(privato)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/utente/"+id, r, {headers: this.dbs.headers})
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteAnimale(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/utente/"+id, {headers: this.dbs.headers})
  }

  public getUserByID(id: String): Observable<UtentePrivato>{
    let result = this.dbs.http.get<UtentePrivato>(this.dbs.baseUrl+"/utente/"+id, {headers: this.dbs.headers})

    return result
  }

  public getUserByEmail(email: String): Observable<UtentePrivato>{
    let result = this.dbs.http.get<UtentePrivato>(this.dbs.baseUrl+"/utente/"+email, {headers: this.dbs.headers})


    return result
  }

}
