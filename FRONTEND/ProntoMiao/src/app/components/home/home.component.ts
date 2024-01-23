import { Component } from '@angular/core';
import { AnimalCardComponent } from '../animal-card/animal-card.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatIconModule} from '@angular/material/icon';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AnimalCardComponent, MatTabsModule, MatIconModule, MatGridListModule, MatCardModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {

}
