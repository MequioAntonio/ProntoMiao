import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Annuncio } from '../../model/Annuncio';
import { Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { RichiestaConfirmComponent } from '../richiesta-confirm/richiesta-confirm.component';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';
import { Richiesta } from '../../model/Richiesta';
import { RichiestaImpl } from '../../model/RichiestaImpl';
import { UtentePrivatoImpl } from '../../model/UtentePrivatoImpl';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-adoption-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, RouterLink],
  templateUrl: './adoption-card.component.html',
  styleUrl: './adoption-card.component.scss',
})
export class AdoptionCardComponent {

  @Input() annuncio?: Annuncio;

  constructor(private authService: AuthService,public dialog: MatDialog, private richiestaService: RichiestaDatabaseService) {}

}
