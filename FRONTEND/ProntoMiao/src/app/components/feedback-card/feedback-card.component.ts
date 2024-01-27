import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { Recensione } from '../../model/Recensione';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-feedback-card',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './feedback-card.component.html',
  styleUrl: './feedback-card.component.scss'
})
export class FeedbackCardComponent {
  recensione!:Recensione;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {

    this.http.get("http://localhost:8080/recensione/"+this.route.snapshot.paramMap.get("idRecensione")).subscribe({
      next:(r:any)=>{
        this.recensione = r;
      },
      error:(e:any)=>{
        console.error(e);

      },
    })
}
}
