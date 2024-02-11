import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class JwtHelperService {

  constructor() { }

  public receiveAndSet(route: ActivatedRoute){
    let token="";
    let keep="";

    route.queryParams.subscribe(params =>{
      token = params["token"]
      keep = params["keep"]
    })

    console.log(token)

    if(token!=undefined && keep!=undefined ){
      if(keep=="true"){
        // console.log("local")
        localStorage.setItem("token", token!)
      }else{
        // console.log("session")
        sessionStorage.setItem("token", token!)
      }
    }
  }

  public sendAndGet(url: String){
    let keep;
    let token;

    if(localStorage.getItem("token") !== null) {
      keep = true;
      token = localStorage.getItem("token");
    } else if(sessionStorage.getItem("token") !== null) {
      keep = false;
      token = sessionStorage.getItem("token");
    } else {
      return null
    }


    location.href=url+"?token="+token+"&keep="+keep;
    return null
  }
}
