import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtTokenResponse } from '../model/JwtTokenResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  signUpEP = `http://localhost:8080/auth/signup`
  signInEP = `http://localhost:8080/auth/login`

  Logged=false
  Privato=true

  constructor(private http: HttpClient)
  { }

  clearToken(){
    sessionStorage.removeItem("token");
    localStorage.removeItem("token");
  }

  getToken() {
    if (sessionStorage.getItem("token")) {
      return sessionStorage.getItem("token");
    }
    if (localStorage.getItem("token")) {
      return localStorage.getItem("token");
    }
    return "";
  }
  
  decodeToken() {
    if (this.getToken() != "") {
      return JSON.parse(window.atob(this.getToken()!.split('.')[1]));
    }
    return null;
  }

  getTipoUtente() {//ritorna "PRIVATO", "CENTRO" o "NA"
    //console.log(this.decodeToken())
    if (this.decodeToken() == null) {
      return null;
    }
    return this.decodeToken().tipo;
  }

  isLogged(){
    return sessionStorage.getItem("token") || localStorage.getItem("token");
    //return this.Logged
  }

  isPrivato(){
    return this.Privato
  }

  isCentro(){
    return !this.Privato
  }

  signUpGeneric(_email: string, _password: string){
    return this.http.post(this.signUpEP, {
      email: _email,
      password: _password,
    })
  }


  signUpPrivatoCentro(request: any){
    return this.http.post(this.signUpEP, request)
  }

  signIn(_email: string, _password: string){
    return this.http.post<JwtTokenResponse>(this.signInEP, {
      email: _email,
      password: _password
    })
  }

  logout() {
    this.clearToken()
    location.href="/";
  }
}
