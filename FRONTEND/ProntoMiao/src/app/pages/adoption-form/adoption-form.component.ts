
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';
import { Subject } from 'rxjs';
import { ValidatorsService } from '../../services/validators.service';
import { Animale } from '../../model/Animale';
import { AnimaleDatabaseService } from '../../services/database-services/animale-database.service';
import { AuthService } from '../../services/auth.service';
import { Component } from '@angular/core';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldAppearance, MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckbox } from '@angular/material/checkbox';
import { MatButton } from '@angular/material/button';
import {MatStepper, MatStepperModule} from '@angular/material/stepper';
import { AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import {Validators} from '@angular/forms';
import { NgIf, CommonModule } from '@angular/common';
import { ChipsComponent } from "../../components/chips/chips.component";
import { routes } from '../../app.routes';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';

@Component({
  selector: 'app-adoption-form',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatCheckbox,
    MatButton,
    MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    ChipsComponent,
    MatSnackBarModule     
  ],
  templateUrl: './adoption-form.component.html',
  styleUrl: './adoption-form.component.scss',
})
export class AdoptionFormComponent {
  
  constructor( private snackBar: MatSnackBar, private authService: AuthService, private fb: FormBuilder, private annuncioService: AnnuncioDatabaseService, private animaleService: AnimaleDatabaseService) {}
  apparenceSetting = 'outline' as MatFormFieldAppearance
  animali : Animale[]= [];
  isLinear = true;

  imageBase64: string = "";
  animaleForm = this.fb.group({
    nome: ['', Validators.required],
    razza: ['', Validators.required],
    specie: ['', Validators.required],
    eta: ['', Validators.required],
    sesso: ['', Validators.required],
    taglia: ['', Validators.required]
  })

  annuncioForm = this.fb.group({
    titolo: ['', [ Validators.required]],
    descrizione: ['', [Validators.required]],
    informazioni: ['', Validators.required],
    animale: ['', Validators.required],  
    
  });

  ngOnInit() {
    this.refreshanimali();
  }

  next(stepper: MatStepper): void{
    stepper.next();
  }

  refreshanimali(){
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

  inserisciAnimale(){
    let animale = {
      nome: this.animaleForm.controls["nome"].value!,
      razza: this.animaleForm.controls["razza"].value!,
      specie: this.animaleForm.controls["specie"].value!,
      eta: this.animaleForm.controls["eta"].value!,
      taglia: this.animaleForm.controls["taglia"].value!,
      sesso: this.animaleForm.controls["sesso"].value!,
    }
    this.annuncioService.insertAnnuncio(animale).subscribe((data) => {
      console.log("inserito animale!");
      this.snackBar.open("Animale creato!","",{duration:3000}).afterDismissed().subscribe(() => {
        location.href="/";
      });
    })

  }


  inserisciAnnuncio() {
    this.refreshanimali();
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
