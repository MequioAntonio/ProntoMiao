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


}
