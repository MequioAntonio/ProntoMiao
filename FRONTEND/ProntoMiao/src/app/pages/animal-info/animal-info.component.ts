import { Component, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Annuncio } from '../../model/Annuncio';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-animal-info',
  standalone: true,
  imports: [MatButtonModule, MatIconModule],
  templateUrl: './animal-info.component.html',
  styleUrl: './animal-info.component.scss',
})
export class AnimalInfoComponent {
  annuncio?: Annuncio;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {

    this.http.get("http://localhost:8080/annuncio/"+this.route.snapshot.paramMap.get("idAnnuncio")).subscribe({
      next:(a:any)=>{
        this.annuncio = a;
      }, 
      error:(e:any)=>{
        console.error(e);

      }, 
    })

  }


}
