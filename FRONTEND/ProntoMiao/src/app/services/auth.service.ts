import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  static signUpEP = `http://backend.url/signup`
  static signInEP = `http://backend.url/signin`

  static Logged=false
  static Privato=true

  static http: HttpClient

  constructor()
  { }

  static isLogged(){
    return this.Logged
  }

  static isPrivato(){
    return this.Privato
  }

  static isCentro(){
    return !this.Privato
  }

  static signUpGeneric(_email: string, _password: string){
    return this.http.post(this.signUpEP, {
      email: _email,
      password: _password,
    })
  }


  static signUpPrivato(_email: string, _password: string){
    return this.http.post(this.signUpEP, {
      email: _email,
      password: _password,
    })
  }


  static signUpCentro(_email: string, _password: string){
    return this.http.post(this.signUpEP, {
      email: _email,
      password: _password,
    })
  }

  static signIn(_email: string, _password: string, _tipo: boolean){
    return this.http.post(this.signInEP, {
      email: _email,
      password: _password
    })
  }
}
