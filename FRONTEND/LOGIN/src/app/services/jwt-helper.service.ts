import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class JwtHelperService {

  constructor() { }

  public receiveAndSet(route: ActivatedRoute){
    let token = route.snapshot.paramMap.get('token');
    let keep = route.snapshot.paramMap.get('keep');

    if(token!="" || keep!="" ){
      if(keep=="true"){
        localStorage.setItem("token", token!)
      }else{
        sessionStorage.setItem("token", token!)
      }
    }
  }

  public sendAndGet(){
    let keep;
    if(localStorage.getItem("token") !== null) {
      keep = true;
    }
    else if(sessionStorage.getItem("token") !== null) {
      keep = false;
    }

    let token;

    if(keep){
      token = localStorage.getItem("token");
    }
    else {
      token = sessionStorage.getItem("token");
    }

    return "?token="+token+"&keep="+keep;
  }
}
