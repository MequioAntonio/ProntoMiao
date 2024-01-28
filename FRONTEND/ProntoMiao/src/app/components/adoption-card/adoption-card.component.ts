import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Annuncio } from '../../model/Annuncio';
import { Input } from '@angular/core';
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
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './adoption-card.component.html',
  styleUrl: './adoption-card.component.scss',
})
export class AdoptionCardComponent {

  @Input() annuncio?: Annuncio;
  @Input() richiesta?: Richiesta | undefined;
  constructor(private authService: AuthService,public dialog: MatDialog, private richiestaService: RichiestaDatabaseService) {}

  adottaAnimale() {
    this.dialog.open(RichiestaConfirmComponent, {
      data: this.annuncio,
    }).afterClosed().subscribe(result => {
      console.log(result);
      if (result && result == "OK") {
        let utentep = new UtentePrivatoImpl();
        utentep.id = this.authService.getIdUtente();
        let richiesta = new RichiestaImpl();
        richiesta.data = new Date();
        richiesta.annuncio = this.annuncio;
        richiesta.utente = utentep;
        this.richiestaService.insertRichiesta(richiesta).subscribe({
          next:(c:any)=>{
            alert("Invio riuscito!")
          },
          error:(e:any)=>{
            console.error(e);
    
          },
        });
      }
    });

  }
}
