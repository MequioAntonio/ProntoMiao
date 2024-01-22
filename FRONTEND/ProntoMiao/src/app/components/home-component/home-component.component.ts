import { Component } from '@angular/core';
import { AnimalCardComponentComponent } from '../animal-card-component/animal-card-component.component';
@Component({
  selector: 'app-home-component',
  standalone: true,
  imports: [AnimalCardComponentComponent],
  templateUrl: './home-component.component.html',
  styleUrl: './home-component.component.scss'
})
export class HomeComponentComponent {

}
