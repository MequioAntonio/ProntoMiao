import { Component } from '@angular/core';
import { AnimalCardComponentComponent } from '../animal-card-component/animal-card-component.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AnimalCardComponentComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  
}
