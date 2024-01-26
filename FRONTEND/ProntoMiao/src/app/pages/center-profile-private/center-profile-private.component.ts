import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { FeedbackCardComponent } from '../../feedback-card/feedback-card.component';
import {MatButtonModule} from '@angular/material/button';


@Component({
  selector: 'app-center-profile-private',
  standalone: true,
  imports: [AnimalCardComponent, FeedbackCardComponent, MatButtonModule],
  templateUrl: './center-profile-private.component.html',
  styleUrl: './center-profile-private.component.scss'
})
export class CenterProfilePrivateComponent {

}
