import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Annuncio } from '../../model/Annuncio';
import { Input } from '@angular/core';
import { Richiesta } from '../../model/Richiesta';

@Component({
  selector: 'app-adoption-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './adoption-card.component.html',
  styleUrl: './adoption-card.component.scss',
})
export class AdoptionCardComponent {

  @Input() annuncio?: Annuncio;
  @Input() richiesta?: Richiesta;

}
