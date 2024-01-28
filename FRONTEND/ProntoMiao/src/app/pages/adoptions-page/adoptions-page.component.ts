import { Component, OnInit } from '@angular/core';
import {MatGridListModule} from '@angular/material/grid-list';
import { AdoptionCardComponent } from "../../components/adoption-card/adoption-card.component";
import { CommonModule } from '@angular/common';
import { AnimaleDatabaseService } from '../../services/database-services/animale-database.service';
import { Annuncio } from '../../model/Annuncio';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';
import { Observable } from 'rxjs';
import { Animale } from '../../model/Animale';

@Component({
    selector: 'app-adoptions-page',
    standalone: true,
    templateUrl: './adoptions-page.component.html',
    styleUrl: './adoptions-page.component.scss',
    imports: [
        MatGridListModule,
        AdoptionCardComponent,
        CommonModule
    ]
})
export class AdoptionsPageComponent implements OnInit {
  annunciLista: Annuncio[] = new Array();

  constructor(private ads: AnnuncioDatabaseService) { }

  ngOnInit(): void {
    this.ads.getAllAnnunciNonAccettati().subscribe((data: any) => {
      this.annunciLista.push(...data)
    })


    // quello sotto è di test

    /*let example: Annuncio = {
      id: 0,
      titolo: "titolo",
      descrizione: "Questo è un esempio, inserito manualmente nel ts",
      foto_profilo: "fotoprofilo",
      informazioni_mediche: "informazionemediche",
      animale:{
        id: 0,
        nome: "Nome",
        razza: "Razza",
        taglia: "TagliaAnimale",
        eta: 99999,
        sesso: "SessoAnimale",
        specie: "SpecieAnimale"
      },
      centro:{
        id: 0,
        nome: "NomeCentro",
        email: "EmailCentro",
        indirizzo: "IndirizzoCentro",
        descrizione: "DescrizioneCentro",
        orari: "OrariCentro",
        eventi: "EventiCentro"
      }
    }
    this.annunciLista.push(example)
  }*/

  //test(){
  //}
}}
