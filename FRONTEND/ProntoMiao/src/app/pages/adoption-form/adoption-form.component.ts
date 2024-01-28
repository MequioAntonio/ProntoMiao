import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormControl,
  FormsModule,
  ReactiveFormsModule,
  Validators,
  FormGroup,
  AbstractControl,
} from '@angular/forms';
import {
  FloatLabelType,
  MatFormFieldModule,
} from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';
import { Subject } from 'rxjs';
import { ValidatorsService } from '../../services/validators.service';
import { Animale } from '../../model/Animale';
import { AnimaleDatabaseService } from '../../services/database-services/animale-database.service';
import { AuthService } from '../../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-adoption-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    MatButtonModule,
    MatDividerModule,
  ],
  templateUrl: './adoption-form.component.html',
  styleUrl: './adoption-form.component.scss',
})
export class AdoptionFormComponent {
  
  constructor( private snackBar: MatSnackBar, private authService: AuthService, private fb: FormBuilder, private annuncioService: AnnuncioDatabaseService, private animaleService: AnimaleDatabaseService) {}

  animali : Animale[]= [];

  imageBase64: string = "";
  annuncioForm = this.fb.group({
    titolo: ['', [ Validators.required]],
    descrizione: ['', [Validators.required]],
    informazioni: ['', Validators.required],
    animale: ['', Validators.required],
  });

  ngOnInit() {
    this.animaleService.getAllAnimaliNotAnnuncio().subscribe((response => {
      this.animali = response;
    }))
  }

  pngInputChange(fileInputEvent: any) {
    console.log(fileInputEvent.target.files[0]);
   this.readFile(fileInputEvent.target.files[0]).subscribe((encoded) => {
    //console.log(encoded)
    let filename = fileInputEvent.target.files[0].name.replaceAll(" ", "_");
    this.imageBase64 = filename + ";" + encoded;
   })
  }

  readFile(file: File) {
    const sub = new Subject<string>();
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      const content: string = reader.result as string;
      sub.next(content);
      sub.complete();
    }
    return sub.asObservable();
  }

  inserisciAnnuncio() {

    /*
{
    "id": 1,
    "descrizione": "annuncio",
    "informazioni_mediche": "mecc",
    "titolo": "ANNUNCIAZIONE",
    "foto_profilo": "foto",
    "centro": {
        "id": 905
    },
    "animale": {
        "id": 4,
    }
}
    */
    let annuncio = {
      descrizione: this.annuncioForm.controls["descrizione"].value!,
      informazioni_mediche: this.annuncioForm.controls["informazioni"].value!,
      titolo: this.annuncioForm.controls["titolo"].value!,
      foto_profilo: this.imageBase64,
      centro: {id: this.authService.getIdUtente()},
      animale: {id: this.annuncioForm.controls["animale"].value!}
    }

    this.annuncioService.insertAnnuncio(annuncio).subscribe((data) => {
      console.log("inserito annuncio!");
      this.snackBar.open("Annuncio creato!","",{duration:3000}).afterDismissed().subscribe(() => {
        location.href="/";
      });
    })
  }
}
