import { Centro } from './../../model/Centro';
import { Component, Input } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { Segnalazione } from '../../model/Segnalazione';
import { SegnalazioneDatabaseService } from '../../services/database-services/segnalazione-database.service';
import { CommonModule, Location } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-segnalation-card',
  standalone: true,
  imports: [MatCardModule, CommonModule, MatButton],
  templateUrl: './segnalation-card.component.html',
  styleUrl: './segnalation-card.component.scss'
})
export class SegnalationCardComponent {

  @Input() segnalazione?: Segnalazione;
  centroID: String;


  constructor(private authService: AuthService, private segnalazioneService: SegnalazioneDatabaseService, private location: Location) {
    this.centroID = this.authService.getIdUtente();

  }

  Gestisci() {
    console.warn(this.segnalazione?.utente)
    let seg = {
      titolo: this.segnalazione?.titolo,
      descrizione: this.segnalazione?.descrizione,
      indirizzo: this.segnalazione?.indirizzo,
      utente: {id: this.segnalazione?.utente.id},
      centro: {id: this.centroID}
    }
    this.segnalazioneService.updateSegnalazione(this.segnalazione!.id!, seg!).subscribe(()=>{
      this.location.replaceState(this.location.path());
      window.location.reload();
    });
  }

}
