import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Input } from '@angular/core';
import { Richiesta } from '../../model/Richiesta';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-request-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './request-card.component.html',
  styleUrl: './request-card.component.scss'
})
export class RequestCardComponent {

  constructor(private richiestaService: RichiestaDatabaseService, private location: Location) {}


  @Input() richiesta?: Richiesta;

  Accetta() {
    let ric = {
      stato: 2,
      data: this.richiesta?.data,
      annuncio: {id: this.richiesta?.annuncio?.id},
      utente: {id: this.richiesta?.utente?.id}
    }
    this.richiestaService.updateRichiesta(this.richiesta!.id, ric!).subscribe(()=>{
      this.location.replaceState(this.location.path());
      window.location.reload();
    });
  }

  Rifiuta() {
    let ric = {
      stato: 1,
      data: this.richiesta?.data,
      annuncio: {id: this.richiesta?.annuncio?.id},
      utente: {id: this.richiesta?.utente?.id}
    }
    this.richiestaService.updateRichiesta(this.richiesta!.id, ric!).subscribe(()=>{
      this.location.replaceState(this.location.path());
      window.location.reload();
    });
  }
}
