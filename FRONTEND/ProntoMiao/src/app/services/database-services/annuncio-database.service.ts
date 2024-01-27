import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Annuncio } from '../../model/Annuncio';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnnuncioDatabaseService extends DatabaseService{

  constructor() { super(); }

  public static getAllAnnunci(){
    super.http.get(super.baseUrl+"/annuncio").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  // NON PRESENTE NEL B.E.
  // public static getAllAnnunciByNome(){
  //   this.http.get(this.baseUrl+"/annuncio/byNome").subscribe({
  //     next:(r:any)=>{
  //       return r;
  //     },
  //     error:(e:any)=>{
  //       console.error(e);
  //     },
  //   })
  // }

  public static insertAnnuncio(annuncio: Annuncio){
    let observable: Observable<Annuncio> = of(annuncio)
    observable.subscribe({
      next:(r:any)=>{
        this.http.post(this.baseUrl+"/annuncio", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }
  // NON PRESENTE NEL B.E.
  // public static updateAnnuncio(id: String, annuncio: Annuncio){
  //   let observable: Observable<Annuncio> = of(annuncio)
  //   observable.subscribe({
  //     next:(r:any)=>{
  //       this.http.post(this.baseUrl+"/annuncio/${id}", r)
  //     },
  //     error:(e:any)=>{
  //       console.error(e);
  //     },

  //   })
  // }

  // NON PRESENTE NEL B.E.
  // public static deleteAnnuncio(id: String){
  //   this.http.delete(this.baseUrl+"/annuncio/${id}")
  // }

  public static getAnnuncioByID(id: String){
    this.http.get(this.baseUrl+"/annuncio/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public static getAllAnnunciByCentro(id_Centro: String){
    this.http.get(this.baseUrl+"/annuncio/byCentro/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }
}
