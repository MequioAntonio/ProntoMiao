import { Injectable } from '@angular/core';
import { DatabaseService } from './database.service';
import { Centro } from '../../model/Centro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CentroAdozioniDatabaseService{

  constructor(private dbs: DatabaseService) { }
  public getAllCentriAdozioni(): Observable<Centro[]> {
    let result = this.dbs.http.get<Centro[]>(this.dbs.baseUrl+"/centro-adozioni")

    return result;
  }

  public getCenterByID(id: String): Observable<Centro> {
    let result = this.dbs.http.get<Centro>(this.dbs.baseUrl+"/centro-adozioni/${id}")

    return result
  }

}
