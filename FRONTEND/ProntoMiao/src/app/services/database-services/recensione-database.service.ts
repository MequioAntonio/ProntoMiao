import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Recensione } from '../../model/Recensione';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecensioneDatabaseService {

  constructor(private dbs: DatabaseService) {}

  public getAllRecensioni(){
    this.dbs.http.get(this.dbs.baseUrl+"/recensione").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public getRecensioneById(id: String){
    this.dbs.http.get(this.dbs.baseUrl+"/recensione/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public getAllRecensioniByCentro(id_Centro: String){
    this.dbs.http.get(this.dbs.baseUrl+"/recensione/byCentro/${id_Centro}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public insertRecensione(recensione: Recensione){
    let observable: Observable<Recensione> = of(recensione)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/recensione", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }

  public deleteRecensioneById(id: String){
    this.dbs.http.delete(this.dbs.baseUrl+"/recensione/${id}")
  }

}
