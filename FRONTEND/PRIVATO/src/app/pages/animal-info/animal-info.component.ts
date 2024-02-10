import { Component, Input, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Annuncio } from '../../model/Annuncio';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';
import { MatDialog } from '@angular/material/dialog';
import { UtentePrivatoImpl } from '../../model/UtentePrivatoImpl';
import { RichiestaImpl } from '../../model/RichiestaImpl';
import { RichiestaConfirmComponent } from '../../components/richiesta-confirm/richiesta-confirm.component';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';
import { AuthService } from '../../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { JwtHelperService } from '../../services/jwt-helper.service';

@Component({
  selector: 'app-animal-info',
  standalone: true,
  imports: [MatButtonModule, MatIconModule,RouterLink],
  templateUrl: './animal-info.component.html',
  styleUrl: './animal-info.component.scss',
})
export class AnimalInfoComponent implements OnInit {
  annuncio!: Annuncio;

  constructor(private jwtHelper: JwtHelperService, private authService: AuthService,public dialog: MatDialog,private ads: AnnuncioDatabaseService, private router: Router, private richiestaService: RichiestaDatabaseService, private snackBar: MatSnackBar, private route: ActivatedRoute) {}
  animalRoute = "/animail-info/"+this.annuncio?.id;


  ngOnInit(): void {

    this.jwtHelper.receiveAndSet(this.route)

    const path = this.router.url;
    const parts = path.split("/");
    const lastElement = parts[parts.length - 1];


    this.ads.getAnnuncioByID(lastElement).subscribe(data=>{
      this.annuncio = data;
    })

  }

  adottaAnimale() {
    this.dialog.open(RichiestaConfirmComponent, {
      data: this.annuncio,
    }).afterClosed().subscribe(result => {
      if (result && result == "OK") {
        let richiesta = {
          id: null,
          stato: 0,
          data: new Date(),
          utente: {id: this.authService.getIdUtente()},
          annuncio: {id: this.annuncio.id}
        }
        this.richiestaService.insertRichiesta(richiesta).subscribe({
          next:(c:any)=>{
            this.snackBar.open("Richiesta inviata.","",{duration:3000}).afterDismissed().subscribe(() => {
              location.href="/";
            });
          },
          error:(e:any)=>{
            console.error(e);

          },
        });
      }
    });
  }


  indirizzamentoCentro(){
    location.href="/centerprofile/"+this.annuncio.centro.id
  }

}
