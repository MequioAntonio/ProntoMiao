import { Component, Input } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { Recensione } from '../../model/Recensione';

@Component({
  selector: 'app-feedback-card',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './feedback-card.component.html',
  styleUrl: './feedback-card.component.scss'
})
export class FeedbackCardComponent {

  @Input() recensione?: Recensione;

  constructor() {}

}
