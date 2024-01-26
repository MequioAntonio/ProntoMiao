import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from '../../model/Centro';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-center-profile-public',
  standalone: true,
  imports: [AnimalCardComponent, FeedbackCardComponent],
  templateUrl: './center-profile-public.component.html',
  styleUrl: './center-profile-public.component.scss'
})
export class CenterProfilePublicComponent {

  centro!: Centro;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {

    this.http.get("http://localhost:8080/centro/"+this.route.snapshot.paramMap.get("idCentro")).subscribe({
      next:(c:any)=>{
        this.centro = c;
      }, 
      error:(e:any)=>{
        console.error(e);

      }, 
    })

  }

}
