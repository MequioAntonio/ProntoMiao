import { Component, Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-small-card',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './small-card.component.html',
  styleUrl: './small-card.component.scss'
})
export class SmallCardComponent {
  @Input() img!: String;
  @Input() alt!: String;


}
