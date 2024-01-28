import { Component, Input, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Annuncio } from '../../model/Annuncio';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';

@Component({
  selector: 'app-animal-info',
  standalone: true,
  imports: [MatButtonModule, MatIconModule],
  templateUrl: './animal-info.component.html',
  styleUrl: './animal-info.component.scss',
})
export class AnimalInfoComponent implements OnInit {
  annuncio!: Annuncio;

  constructor(private ads: AnnuncioDatabaseService, private router: Router) {}

  ngOnInit(): void {
    const path = this.router.url;
    const parts = path.split("/");
    const lastElement = parts[parts.length - 1];


    this.ads.getAnnuncioByID(lastElement).subscribe(data=>{
      this.annuncio = data;
    })

  }



}
