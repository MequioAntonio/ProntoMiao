import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class JwtHelperService {

  constructor() { }

  public reciveAndSet(route: ActivatedRoute){
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
}
