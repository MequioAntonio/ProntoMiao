import { Component } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import {MatButtonModule} from '@angular/material/button';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from '../../model/Centro';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-center-profile-private',
  standalone: true,
  imports: [AdoptionCardComponent, FeedbackCardComponent, MatButtonModule],
  templateUrl: './center-profile-private.component.html',
  styleUrl: './center-profile-private.component.scss'
})
export class CenterProfilePrivateComponent {

    //string immagine?
    centro!: Centro;

    constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {

    this.http.get("http://localhost:8080/centro-adozioni/"+this.route.snapshot.paramMap.get("idCentro")).subscribe({
      next:(c:any)=>{
        this.centro = c;
      },
      error:(e:any)=>{
        console.error(e);

      },
    })

  }

  //RICORDARSI DI FARE I METODI AGGIUNGIANNUNCIO E MODIFICAPROFILO

    //Fare modificaProfilo
    modificaProfilo(){}

    aggiungiAdozione(){
      location.href="/adoption-form";
    }

}
