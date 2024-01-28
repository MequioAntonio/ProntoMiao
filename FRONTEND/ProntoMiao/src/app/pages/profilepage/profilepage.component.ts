import { Component } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import { UtentePrivato } from '../../model/UtentePrivato';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-profilepage',
  standalone: true,
  imports: [AdoptionCardComponent],
  templateUrl: './profilepage.component.html',
  styleUrl: './profilepage.component.scss'
})
export class ProfilepageComponent {

  utenteprivato!: UtentePrivato;

  constructor(private authService: AuthService, private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get("http://localhost:8080/utente/"+this.authService.getIdUtente()).subscribe({
      next:(u:any)=>{
        this.utenteprivato = u;
      },
      error:(e:any)=>{
        console.error(e);

      },
    })

  }

}
