import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  signUpEP = `http://backend.url/signup`
  signInEP = `http://backend.url/signin`

  Logged=false
  Privato=true

  constructor(private http: HttpClient)
  { }

  isLogged(){
    return this.Logged
  }

  isPrivato(){
    return this.Privato
  }

  isCentro(){
    return !this.Privato
  }

  signUp(_email: string, _password: string, _tipo: boolean){
    return this.http.post(this.signUpEP, {
      email: _email,
      password: _password,
      tipo: _tipo
    })
  }

  signIn(_email: string, _password: string, _tipo: boolean){
    return this.http.post(this.signInEP, {
      email: _email,
      password: _password
    })
  }
}
