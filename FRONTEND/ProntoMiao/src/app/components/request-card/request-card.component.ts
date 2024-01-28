import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Input } from '@angular/core';
import { Richiesta } from '../../model/Richiesta';

@Component({
  selector: 'app-request-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './request-card.component.html',
  styleUrl: './request-card.component.scss'
})
export class RequestCardComponent {

  @Input() richiesta?: Richiesta;
}
