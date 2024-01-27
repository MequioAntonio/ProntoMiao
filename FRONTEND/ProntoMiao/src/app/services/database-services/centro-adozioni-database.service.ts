import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';

@Injectable({
  providedIn: 'root'
})
export class CentroAdozioniDatabaseService{

  constructor(private dbs: DatabaseService) { }
  public getAllCentriAdozioni(){
    this.dbs.http.get(this.dbs.baseUrl+"/centro-adozioni").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public getCenterByID(id: String){
    this.dbs.http.get(this.dbs.baseUrl+"/centro-adozioni/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

}
