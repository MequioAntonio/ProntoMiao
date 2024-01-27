import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Annuncio } from '../../model/Annuncio';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnnuncioDatabaseService {

  constructor(private dbs: DatabaseService) { }

  public getAllAnnunci(): Annuncio[] {
    let result: Annuncio[] = [] ;
    this.dbs.http.get(this.dbs.baseUrl+"/annuncio").subscribe({
      next:(r:any)=>{
        console.log(r);
        result = r;
      },
      error:(e:any)=>{
        console.error("mario");
        console.error(e);
      },
    })
    return result
  }

  // NON PRESENTE NEL B.E.
  // public getAllAnnunciByNome(){
  //   this.dbs.http.get(this.dbs.baseUrl+"/annuncio/byNome").subscribe({
  //     next:(r:any)=>{
  //       return r;
  //     },
  //     error:(e:any)=>{
  //       console.error(e);
  //     },
  //   })
  // }

  public insertAnnuncio(annuncio: Annuncio){
    let observable: Observable<Annuncio> = of(annuncio)
    observable.subscribe({
      next:(r:any)=>{
        this.dbs.http.post(this.dbs.baseUrl+"/annuncio", r)
      },
      error:(e:any)=>{
        console.error(e);
      },

    })
  }
  // NON PRESENTE NEL B.E.
  // public updateAnnuncio(id: String, annuncio: Annuncio){
  //   let observable: Observable<Annuncio> = of(annuncio)
  //   observable.subscribe({
  //     next:(r:any)=>{
  //       this.dbs.http.post(this.dbs.baseUrl+"/annuncio/${id}", r)
  //     },
  //     error:(e:any)=>{
  //       console.error(e);
  //     },

  //   })
  // }

  // NON PRESENTE NEL B.E.
  // public deleteAnnuncio(id: String){
  //   this.dbs.http.delete(this.dbs.baseUrl+"/annuncio/${id}")
  // }

  public getAnnuncioByID(id: String){
    this.dbs.http.get(this.dbs.baseUrl+"/annuncio/${id}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }

  public getAllAnnunciByCentro(id_Centro: String){
    this.dbs.http.get(this.dbs.baseUrl+"/annuncio/byCentro/${id_Centro}").subscribe({
      next:(r:any)=>{
        return r;
      },
      error:(e:any)=>{
        console.error(e);
      },
    })
  }
}
