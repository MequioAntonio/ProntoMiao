import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-animal-info',
  standalone: true,
  imports: [MatButtonModule, MatIconModule],
  templateUrl: './animal-info.component.html',
  styleUrl: './animal-info.component.scss',
})
export class AnimalInfoComponent {}
