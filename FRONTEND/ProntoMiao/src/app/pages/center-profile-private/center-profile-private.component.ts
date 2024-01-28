import { Component } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import { MatButtonModule } from '@angular/material/button';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from '../../model/Centro';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Richiesta } from '../../model/Richiesta';
import { Recensione } from '../../model/Recensione';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';
import { RecensioneDatabaseService } from '../../services/database-services/recensione-database.service';
import { CommonModule } from '@angular/common';
import { CentroAdozioniDatabaseService } from '../../services/database-services/centro-adozioni-database.service';
import { RequestCardComponent } from '../../components/request-card/request-card.component';

@Component({
  selector: 'app-center-profile-private',
  standalone: true,
  imports: [AdoptionCardComponent, FeedbackCardComponent, MatButtonModule, CommonModule, RequestCardComponent],
  templateUrl: './center-profile-private.component.html',
  styleUrl: './center-profile-private.component.scss',
})
export class CenterProfilePrivateComponent {
  //string immagine?
  centro!: Centro;

  richieste?: Richiesta[] = new Array();

  recensioni?: Recensione[] = new Array();

  constructor(
    private cds: CentroAdozioniDatabaseService,
    private ric: RichiestaDatabaseService,
    private rds: RecensioneDatabaseService,
    private router: Router
  ) {}

  ngOnInit(): void {

    const path = this.router.url;
    const parts = path.split("/");
    const lastElement = parts[parts.length - 1];

    this.cds.getCenterByID(lastElement).subscribe(data=>{
      this.centro = data;
    })

    this.ric.getAllRichiesteByCentro(lastElement).subscribe(data=>{
      console.warn(data)
      this.richieste = data;
    })

    this.rds.getAllRecensioniByCentro(lastElement).subscribe(data=>{
      this.recensioni = data;
    })

  }

  //RICORDARSI DI FARE I METODI AGGIUNGIANNUNCIO E MODIFICAPROFILO

  //Fare modificaProfilo
  modificaProfilo() {}

  aggiungiAdozione() {
    location.href = '/adoption-form';
  }
}
