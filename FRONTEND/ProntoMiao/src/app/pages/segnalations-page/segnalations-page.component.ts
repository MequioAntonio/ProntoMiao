import { Component } from '@angular/core';
import { SegnalationFormComponent } from '../segnalation-form/segnalation-form.component';

@Component({
  selector: 'app-segnalations-page',
  standalone: true,
  imports: [SegnalationFormComponent],
  templateUrl: './segnalations-page.component.html',
  styleUrl: './segnalations-page.component.scss'
})
export class SegnalationsPageComponent {

}
