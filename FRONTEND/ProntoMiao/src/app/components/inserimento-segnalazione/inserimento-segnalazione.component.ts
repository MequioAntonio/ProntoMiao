import { Component } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-inserimento-segnalazione',
  standalone: true,
  imports: [
    MatFormFieldModule
  ],
  templateUrl: './inserimento-segnalazione.component.html',
  styleUrl: './inserimento-segnalazione.component.scss'
})
export class InserimentoSegnalazioneComponent {

}
