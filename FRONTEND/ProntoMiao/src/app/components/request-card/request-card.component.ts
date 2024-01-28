import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Input } from '@angular/core';
import { Richiesta } from '../../model/Richiesta';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';

@Component({
  selector: 'app-request-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './request-card.component.html',
  styleUrl: './request-card.component.scss'
})
export class RequestCardComponent {

  constructor(private richiestaService: RichiestaDatabaseService) {}


  @Input() richiesta?: Richiesta;

  Accetta() {
    this.richiesta!.stato = 2
    this.richiestaService.updateRichiesta(this.richiesta!.id, this.richiesta!)
  }

  Rifiuta() {
    this.richiesta!.stato = 1
    this.richiestaService.updateRichiesta(this.richiesta!.id, this.richiesta!)
  }
}
