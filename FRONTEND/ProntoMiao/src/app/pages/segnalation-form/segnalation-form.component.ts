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
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from '../../services/auth.service';
import { SegnalazioneDatabaseService } from '../../services/database-services/segnalazione-database.service';

@Component({
  selector: 'app-segnalation-form',
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
  templateUrl: './segnalation-form.component.html',
  styleUrl: './segnalation-form.component.scss',
})
export class SegnalationFormComponent {
  pngInputChange(fileInputEvent: any) {
    console.log(fileInputEvent.target.files[0]);
  }

  constructor (private auth: AuthService, private fb: FormBuilder, private segnalazioneservice : SegnalazioneDatabaseService, private snackBar: MatSnackBar){}

  segnalationForm = this.fb.group({
    titolo: ['', [ Validators.required,]],
    descrizione: ['', [Validators.required]],
    indirizzo: ['', Validators.required],
  });

  inserisciSegnalazione() {
    let req = {
      titolo: this.segnalationForm.controls["titolo"].value!,
      descrizione: this.segnalationForm.controls["descrizione"].value!,
      indirizzo: this.segnalationForm.controls["indirizzo"].value!,
      privato: {id: this.auth.getIdUtente()},
      centro: {id: this.auth.getIdUtente()},

    }
    this.segnalazioneservice.insertSegnalazione(req).subscribe((data) => {
      console.log("inserita segnalazione!");
      this.snackBar.open("Segnalazione creata!","",{duration:3000}).afterDismissed().subscribe(() => {
        location.href="/";
      });
    })




  }

}
