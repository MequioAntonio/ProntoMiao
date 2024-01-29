import { Component } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import { UtentePrivato } from '../../model/UtentePrivato';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';
import { Richiesta } from '../../model/Richiesta';
import { UtentePrivatoDatabaseService } from '../../services/database-services/utente-privato-database.service';
import { CommonModule } from '@angular/common';
import { RequestCardComponent } from "../../components/request-card/request-card.component";

@Component({
    selector: 'app-profilepage',
    standalone: true,
    templateUrl: './profilepage.component.html',
    styleUrl: './profilepage.component.scss',
    imports: [AdoptionCardComponent, CommonModule, RequestCardComponent]
})
export class ProfilepageComponent {

  utenteprivato!: UtentePrivato;

  richieste?: Richiesta[] = new Array();

  constructor(
    private ute: UtentePrivatoDatabaseService,
    private ric: RichiestaDatabaseService,
    private router: Router,
    private as: AuthService) {}

    isCentro = this.as.isCentro()

  ngOnInit(): void {

    const path = this.router.url;
    const parts = path.split("/");
    const lastElement = parts[parts.length - 1];

    this.ute.getUserByID(lastElement).subscribe(data=>{
      this.utenteprivato = data;
    })

    this.ric.getAllRichiesteByUtente(lastElement).subscribe(data=>{
      this.richieste = data;
    })

  }

}
