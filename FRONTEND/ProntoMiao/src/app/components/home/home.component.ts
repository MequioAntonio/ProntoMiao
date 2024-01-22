import { Component } from '@angular/core';
import { AnimalCardComponent } from '../animal-card/animal-card.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AnimalCardComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {

}
