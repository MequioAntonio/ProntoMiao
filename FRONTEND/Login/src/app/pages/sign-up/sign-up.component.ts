import { Component } from '@angular/core';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldAppearance, MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckbox } from '@angular/material/checkbox';
import { MatButton } from '@angular/material/button';
import {MatStepper, MatStepperModule} from '@angular/material/stepper';
import { AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import {Validators} from '@angular/forms';
import { ValidatorsService } from '../../services/validators.service';
import { NgIf, CommonModule } from '@angular/common';
import { ChipsComponent } from "../../components/chips/chips.component";
import { AuthService } from '../../services/auth.service';
import { routes } from '../../app.routes';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';


@Component({
    selector: 'app-sign-up',
    standalone: true,
    providers: [ValidatorsService, AuthService],
    templateUrl: './sign-up.component.html',
    styleUrl: './sign-up.component.scss',
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
    ]
})

export class SignUpComponent {
  apparenceSetting = 'outline' as MatFormFieldAppearance
  isLinear = true
  otherUserData = {
    zero: "Altri Dati",
    one: "Privato",
    two: "Centro Adozioni"
  }

  tipoUtente = this.otherUserData["zero"]

  constructor(private fb: FormBuilder, private authService: AuthService, private snackBar: MatSnackBar) {}


  genericFrom = this.fb.group({
    email: ['', [ Validators.required, ValidatorsService.emailValidator()]],
    password: ['', [Validators.required, ValidatorsService.passwordValidator(), Validators.minLength(8)]],
    tipo: ['', Validators.required],
    terms: ['', Validators.required],
  });

  privatoForm = this.fb.group({
    nome: ['', Validators.required],
    cognome: ['', Validators.required],
    cf: ['', Validators.required],
    indirizzo: [''],
    telefono: [''],
    preferenze: [''],
    condizioni: [''],
    infromazioni: [''],
  });

  centroForm = this.fb.group({
    nome: ['', Validators.required],
    desc: ['', Validators.required],
    orari: ['', Validators.required],
    indirizzo: ['', Validators.required],
    eventi: [''],
  });



  getControlName(control: AbstractControl): string {
    const parent = control.parent;
    const formGroup = parent as FormGroup;
    return (
      Object.keys(formGroup.controls).find(
        (key) => control === formGroup.get(key)
      ) || ''
    );
  }


  getErrorMessage(control: AbstractControl) {
    if (this.getControlName(control) == 'email') {
      if (control.hasError('required')) {
        return 'Devi inserire una Email!';
      }else if (control.hasError('invalidEmail')){
        return 'Inserire un Email Valida!'
      } else {
        return null
      }

    } else if (this.getControlName(control) == 'password') {
      if (control.hasError('required')) {
        return 'Devi inserire una Password!';
      } else if (control.hasError('uppercase')){
        return 'Usa un carattere maiuscolo! (A-Z)'
      } else if (control.hasError('lowercase')){
        return 'Usa un carattere minuscolo! (a-z)'
      } else if (control.hasError('digit')){
        return 'Usa un carattere numerico! (0-9)'
      } else if (control.hasError('symbol')){
        return 'Usa un carattere simbolo! (!@#$%^&*)'
      } else if (control.hasError('minlength')){
        return 'Usa una password più lunga di 8 caratteri!'
      } else {
        return null
      }

    } else if (this.getControlName(control) == 'tipo') {
      if (control.hasError('required')) {
        return 'Scegli un tipo di Account!';
      } else {
        return null
      }

    } else if (this.getControlName(control) == 'terms') {
      if (control.hasError('required')) {
        return 'Accettare per continuare!';
      } else {
        return null
      }
    } else {
      return null
    }
  }

  next(stepper: MatStepper): void{
    this.genericFrom.get('tipo')!.value == "one" ?
    this.tipoUtente = this.otherUserData["one"]
    : this.tipoUtente = this.otherUserData["two"]


    stepper.next();

  }


  signupPrivato(): void{
    var req = {
      email: this.genericFrom.controls["email"].value!,
      password: this.genericFrom.controls["password"].value!,
      tipoUtente: "Privato",
      nome: this.privatoForm.controls["nome"].value!,
      cognome: this.privatoForm.controls["cognome"].value!,
      cf: this.privatoForm.controls["cf"].value!,
      indirizzo: this.privatoForm.controls["indirizzo"].value!,
      telefono: this.privatoForm.controls["telefono"].value!,
      preferenze: this.privatoForm.controls["preferenze"].value!,
      condizioni: this.privatoForm.controls["condizioni"].value!,
      informazioni: this.privatoForm.controls["infromazioni"].value!,
    }
    this.authService.signUpPrivatoCentro(req
    ).subscribe({
      next:(a:any)=>{
        if (a.id > 0) {
          //alert("Registrazione è avvenuta con successo!")
          this.snackBar.open("Registrazione è avvenuta con successo!","",{duration:3000}).afterDismissed().subscribe(() => {
            location.href="/login";
          });
        }
      },
      error:(e:any)=>{
        this.snackBar.open("ERRORE! Registrazione non avvenuta!","",{duration:3000});

      },

    })



  }

  signupCentro(): void{
    var req = {
      email: this.genericFrom.controls["email"].value!,
      password: this.genericFrom.controls["password"].value!,
      tipoUtente: "Centro Adozioni",
      nome: this.centroForm.controls["nome"].value!,
      descrizione: this.centroForm.controls["desc"].value!,
      orari: this.centroForm.controls["orari"].value!,
      indirizzo: this.centroForm.controls["indirizzo"].value!,
      eventi: this.centroForm.controls["eventi"].value!,
    }

    this.authService.signUpPrivatoCentro(
      req
    ).subscribe({
      next:(a:any)=>{
        if (a.id > 0) {
          //alert("Registrazione è avvenuta con successo!")
          this.snackBar.open("Registrazione è avvenuta con successo!","",{duration:3000}).afterDismissed().subscribe(() => {
            location.href="/login";
          });
        }
      },
      error:(e:any)=>{
        this.snackBar.open("ERRORE! Registrazione non avvenuta!","",{duration:3000});

      },

    })

  }



}
