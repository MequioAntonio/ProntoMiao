import { Component } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-inserimento-annuncio-component',
  standalone: true,
  imports: [
    MatFormFieldModule,
  ],
  templateUrl: './inserimento-annuncio-component.component.html',
  styleUrl: './inserimento-annuncio-component.component.scss'
})
export class InserimentoAnnuncioComponentComponent {

}
