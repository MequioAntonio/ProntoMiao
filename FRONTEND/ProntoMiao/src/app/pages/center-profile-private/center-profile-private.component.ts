import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import {MatButtonModule} from '@angular/material/button';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from '../../model/Centro';

@Component({
  selector: 'app-center-profile-private',
  standalone: true,
  imports: [AnimalCardComponent, FeedbackCardComponent, MatButtonModule],
  templateUrl: './center-profile-private.component.html',
  styleUrl: './center-profile-private.component.scss'
})
export class CenterProfilePrivateComponent {

    //string immagine?
    centro!: Centro;

    //Fare costruttore

    //Fare modificaProfilo

    //Fare aggiungiAdozione

}
