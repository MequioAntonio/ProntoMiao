import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { Annuncio } from '../../model/Annuncio';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';

@Component({
  selector: 'app-userhome',
  standalone: true,
  imports: [AnimalCardComponent],
  templateUrl: './userhome.component.html',
  styleUrl: './userhome.component.scss'
})
export class UserhomeComponent {

  listaAnnunci?: Annuncio[];

  constructor(private annuncioservice: AnnuncioDatabaseService) {}

  ngOnInit() {
    this.getAnnunci();
  }
  
  getAnnunci(): void {
    this.listaAnnunci = this.annuncioservice.getAllAnnunci();
  }

}
