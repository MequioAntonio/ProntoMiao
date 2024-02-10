import { Segnalazione } from './../../model/Segnalazione';
import { Component, OnInit } from '@angular/core';
import { SegnalationFormComponent } from '../segnalation-form/segnalation-form.component';
import { SegnalazioneDatabaseService } from '../../services/database-services/segnalazione-database.service';
import { MatGridList, MatGridTile } from '@angular/material/grid-list';
import { SegnalationCardComponent } from '../../components/segnalation-card/segnalation-card.component';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { JwtHelperService } from '../../services/jwt-helper.service';

@Component({
  selector: 'app-segnalations-page',
  standalone: true,
  imports: [MatGridList, MatGridTile, SegnalationCardComponent, CommonModule],
  templateUrl: './segnalations-page.component.html',
  styleUrl: './segnalations-page.component.scss'
})
export class SegnalationsPageComponent implements OnInit {
  segnalazioniLista: Segnalazione[] = new Array();

  constructor(private seg: SegnalazioneDatabaseService, private jwtHelper: JwtHelperService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.jwtHelper.reciveAndSet(this.route)

    this.seg.getAllSegnalazioni().subscribe((data: any) => {
      console.warn(data)
      data.forEach((segnalazione: Segnalazione) => {
        console.warn(segnalazione)
        if(segnalazione.centro == null) {
          this.segnalazioniLista.push(segnalazione)
        }
      });
    })
  }
}
