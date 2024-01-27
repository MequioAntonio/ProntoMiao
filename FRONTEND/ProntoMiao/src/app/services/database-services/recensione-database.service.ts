import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';

@Injectable({
  providedIn: 'root'
})
export class RecensioneDatabaseService extends DatabaseService {

  constructor() { super(); }



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

}
