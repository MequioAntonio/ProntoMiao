import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { Annuncio } from '../../model/Annuncio';

@Component({
  selector: 'app-userhome',
  standalone: true,
  imports: [AnimalCardComponent],
  templateUrl: './userhome.component.html',
  styleUrl: './userhome.component.scss'
})
export class UserhomeComponent {

  annunci?: Annuncio[];

}
