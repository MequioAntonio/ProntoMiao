import { Component } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';

@Component({
  selector: 'app-inserimento-segnalazione',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule, 
    MatSelectModule
  ],
  templateUrl: './inserimento-segnalazione.component.html',
  styleUrl: './inserimento-segnalazione.component.scss'
})
export class InserimentoSegnalazioneComponent {

}
