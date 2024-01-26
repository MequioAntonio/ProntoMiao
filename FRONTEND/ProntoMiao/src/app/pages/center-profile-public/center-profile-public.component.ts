import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from "../model/Centro";
@Component({
  selector: 'app-center-profile-public',
  standalone: true,
  imports: [AnimalCardComponent, FeedbackCardComponent],
  templateUrl: './center-profile-public.component.html',
  styleUrl: './center-profile-public.component.scss'
})
export class CenterProfilePublicComponent {

  centro!: Centro;

}
