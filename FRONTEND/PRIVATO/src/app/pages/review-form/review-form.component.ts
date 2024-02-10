import { DatabaseService } from './../../services/database-services/database.service';
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
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatButtonModule } from '@angular/material/button';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { RecensioneDatabaseService } from '../../services/database-services/recensione-database.service';
import { Recensione } from '../../model/Recensione';
import { JwtHelperService } from '../../services/jwt-helper.service';
@Component({
  selector: 'app-review-form',
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
  templateUrl: './review-form.component.html',
  styleUrl: './review-form.component.scss'
})
export class ReviewFormComponent implements OnInit {
  pngInputChange(fileInputEvent: any) {
    console.log(fileInputEvent.target.files[0]);
  }

  votoControl = new FormControl('', [Validators.required]);
  descrizioneControl = new FormControl('', [Validators.required]);
  userID: number;
  idCentro!: string;

  constructor(private jwtHelper: JwtHelperService, private authService: AuthService, private route: ActivatedRoute, private recensioneService: RecensioneDatabaseService, private snackBar: MatSnackBar) {
    this.userID = this.authService.getIdUtente();
  }

  ngOnInit(): void {

    this.jwtHelper.receiveAndSet(this.route)

    this.route.paramMap.subscribe(params => {
      this.idCentro = params.get('idCentro')!;
    });
    console.log(this.votoControl.value)
    console.log(this.descrizioneControl.value)
    console.log(this.userID)
    console.log(this.idCentro)

  }

  inserisciRecensione() {

    let recensione = {
      voto: this.votoControl.value,
      descrizione: this.descrizioneControl.value,
      privato: {id: this.userID},
      centro: {id: this.idCentro}
    }

    this.recensioneService.insertRecensione(recensione).subscribe((data) => {
      console.log("inserito Recensione!");
      this.snackBar.open("Recensione inserita con Successo!","",{duration:3000});
    })
  }
}
