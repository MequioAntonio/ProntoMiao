import { Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-animal-card-component',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './animal-card-component.component.html',
  styleUrl: './animal-card-component.component.scss'
})
export class AnimalCardComponentComponent {

}
