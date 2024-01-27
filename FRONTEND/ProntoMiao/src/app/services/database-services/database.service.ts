import { HttpClient, HttpHandler } from '@angular/common/http';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  constructor(public http: HttpClient) { }

  public baseUrl = 'http://localhost:8080';
}
