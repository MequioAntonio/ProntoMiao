import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';

@Component({
  selector: 'app-center-profile-public',
  standalone: true,
  imports: [AnimalCardComponent, FeedbackCardComponent],
  templateUrl: './center-profile-public.component.html',
  styleUrl: './center-profile-public.component.scss'
})
export class CenterProfilePublicComponent {

}
