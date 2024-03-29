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
  MatFormFieldAppearance,
  MatFormFieldModule,
} from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { AuthService } from '../../services/auth.service';
import { ValidatorsService } from '../../services/validators.service';
import { JwtTokenResponse } from '../../model/JwtTokenResponse';
import { JwtHelperService } from '../../services/jwt-helper.service';

@Component({
  selector: 'app-login',
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
  providers: [AuthService, ValidatorsService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  apparenceSetting = 'outline' as MatFormFieldAppearance
  jwtToken: JwtTokenResponse | undefined;

  constructor(private fb: FormBuilder, private authService: AuthService, private jh: JwtHelperService) {}

  loginForm = this.fb.group({
    email: ['', [Validators.required, ValidatorsService.emailValidator()]],
    password: ['', [Validators.required,Validators.minLength(8)]],
    keepConnected:['']
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
      } else if (control.hasError('minlength')) {
        return 'Inserire una Password valida!';
      } else {
        return null
      }
    } else {
      return null;
    }
  }

  login(): void{
    console.log(this.loginForm.controls["keepConnected"].value)
    this.authService.signIn(
      this.loginForm.controls["email"].value!,
      this.loginForm.controls["password"].value!
    ).subscribe((data) =>{
      this.authService.clearToken()
      if (this.loginForm.controls["keepConnected"].value){
        sessionStorage.removeItem("token");
        localStorage.setItem("token", data.token);
      } else {
        localStorage.removeItem("token");
        sessionStorage.setItem("token", data.token);
      }
      console.log(data);

      if(this.authService.isLogged()) {
        if(this.authService.isPrivato()) {
          this.jh.sendAndGet("http://localhost:4220/")
        }
        else {
          this.jh.sendAndGet("http://localhost:4210/")
        }
      }

    });
    console.log(this.loginForm);
  }


}
