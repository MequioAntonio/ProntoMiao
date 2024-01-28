import { Component, OnInit } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from '../../model/Centro';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CentroAdozioniDatabaseService } from '../../services/database-services/centro-adozioni-database.service';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';
import { Annuncio } from '../../model/Annuncio';
import { CommonModule } from '@angular/common';
import { RecensioneDatabaseService } from '../../services/database-services/recensione-database.service';
import { Recensione } from '../../model/Recensione';

@Component({
  selector: 'app-center-profile-public',
  standalone: true,
  imports: [AdoptionCardComponent, FeedbackCardComponent, CommonModule],
  templateUrl: './center-profile-public.component.html',
  styleUrl: './center-profile-public.component.scss'
})
export class CenterProfilePublicComponent implements OnInit{

  centro?: Centro;

  annunci?: Annuncio[] = new Array();

  recensioni?: Recensione[] = new Array();

  constructor(private cds: CentroAdozioniDatabaseService, private ads: AnnuncioDatabaseService, private rds: RecensioneDatabaseService, private router: Router) {}


  ngOnInit(): void {

    const path = this.router.url;
    const parts = path.split("/");
    const lastElement = parts[parts.length - 1];

    this.cds.getCenterByID(lastElement).subscribe(data=>{
      this.centro = data;
    })

    this.ads.getAllAnnunciByCentro(lastElement).subscribe(data=>{
      console.log("AByC");
      console.log(data);
      this.annunci = data;

    })

    this.rds.getAllRecensioniByCentro(lastElement).subscribe(data=>{
      console.log("rec");
      console.log(data);
      this.recensioni = data;

    })

  }

}
