import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { UtentePrivato } from '../model/UtentePrivato.ts';

@Component({
  selector: 'app-profilepage',
  standalone: true,
  imports: [AnimalCardComponent],
  templateUrl: './profilepage.component.html',
  styleUrl: './profilepage.component.scss'
})
export class ProfilepageComponent {

  utenteprivato!: UtentePrivato;

}
