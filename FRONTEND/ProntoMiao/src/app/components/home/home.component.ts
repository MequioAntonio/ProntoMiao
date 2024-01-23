import { Component } from '@angular/core';
import { AnimalCardComponent } from '../animal-card/animal-card.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatIconModule} from '@angular/material/icon';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AnimalCardComponent, MatTabsModule, MatIconModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {

}
