import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import { Annuncio } from '../../model/Annuncio';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';

@Component({
  selector: 'app-userhome',
  standalone: true,
  imports: [AdoptionCardComponent],
  templateUrl: './userhome.component.html',
  styleUrl: './userhome.component.scss'
})
export class UserhomeComponent {

  listaAnnunci?: Annuncio[];

  constructor(private annuncioservice: AnnuncioDatabaseService) {}

  ngOnInit() : void {
    this.getAnnunci();
    console.log("ON INIT" + this.listaAnnunci!.length);
  }

  getAnnunci(): void {



    console.log("ho ottenuto gli annunci" + this.listaAnnunci!.length);
  }


}
