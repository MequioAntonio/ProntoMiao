import { Component } from '@angular/core';
import { AnimalCardComponent } from '../../components/animal-card/animal-card.component';
import { UtentePrivato } from '../../model/UtentePrivato';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profilepage',
  standalone: true,
  imports: [AnimalCardComponent],
  templateUrl: './profilepage.component.html',
  styleUrl: './profilepage.component.scss'
})
export class ProfilepageComponent {

  utenteprivato!: UtentePrivato;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {

    this.http.get("http://localhost:8080/utente/"+this.route.snapshot.paramMap.get("idUtente")).subscribe({
      next:(u:any)=>{
        this.utenteprivato = u;
      }, 
      error:(e:any)=>{
        console.error(e);

      }, 
    })

  }

}
