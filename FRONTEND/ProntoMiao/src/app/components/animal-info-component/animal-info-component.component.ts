import { Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-animal-info-component',
  standalone: true,
  imports: [MatButtonModule,MatIconModule],
  templateUrl: './animal-info-component.component.html',
  styleUrl: './animal-info-component.component.scss'
})
export class AnimalInfoComponentComponent {

}
