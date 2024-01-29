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
import { ActivatedRoute } from '@angular/router';

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
export class SegnalationFormComponent implements OnInit{
  pngInputChange(fileInputEvent: any) {
    console.log(fileInputEvent.target.files[0]);
  }

  titoloControl = new FormControl('', [Validators.required]);
  descrizioneControl = new FormControl('', [Validators.required]);
  indirizzoControl = new FormControl('', [Validators.required]);
  userID: number;

  constructor (private authService: AuthService, private fb: FormBuilder, private route: ActivatedRoute, private segnalazioneService : SegnalazioneDatabaseService, private snackBar: MatSnackBar){
    this.userID = this.authService.getIdUtente();
  }

  ngOnInit(): void {

    console.log('Titolo:', this.titoloControl.value)
    console.log('Descrizione:', this.descrizioneControl.value)
    console.log('Indirizzo:', this.indirizzoControl.value)
    console.log('UserID:', this.userID)

  }

  inserisciSegnalazione() {

    let segnalazione = {

      titolo: this.titoloControl.value,
      descrizione: this.descrizioneControl.value,
      indirizzo: this.indirizzoControl.value,
      utente: {id: this.userID}

    }

    this.segnalazioneService.insertSegnalazione(segnalazione).subscribe((data) => {
      console.log("inserita segnalazione!");
      this.snackBar.open("Segnalazione inserita con Successo!","",{duration:3000});
      location.href="/";
    })
  }

}
