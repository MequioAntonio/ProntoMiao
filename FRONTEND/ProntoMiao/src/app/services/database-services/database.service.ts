import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '../auth.service';



@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  constructor(public http: HttpClient, public authService: AuthService) { }

  public baseUrl = 'http://localhost:8080';

  public headers = new HttpHeaders({'Authorization':'Bearer '+this.authService.getToken()});

}
