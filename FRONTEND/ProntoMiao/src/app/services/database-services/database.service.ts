import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  constructor() { }

  protected static baseUrl = 'http://localhost:8080/';

  protected static http: HttpClient
}
