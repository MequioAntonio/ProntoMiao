import { Component } from '@angular/core';
import {MatGridListModule} from '@angular/material/grid-list';
import { AnimalCardComponent } from "../../components/animal-card/animal-card.component";
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-adoptions-page',
    standalone: true,
    templateUrl: './adoptions-page.component.html',
    styleUrl: './adoptions-page.component.scss',
    imports: [
        MatGridListModule,
        AnimalCardComponent,
        CommonModule
    ]
})
export class AdoptionsPageComponent {
  annunci = [
    {nome: "Shiba Inu", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Beagle", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Pastore Tedesco", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Aski", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Shiba Inu", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Beagle", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Pastore Tedesco", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
    {nome: "Aski", razza: "Dog Breed", descrizione: "descrizione di prova", immagine: "https://material.angular.io/assets/img/examples/shiba2.jpg"},
  ]
}
