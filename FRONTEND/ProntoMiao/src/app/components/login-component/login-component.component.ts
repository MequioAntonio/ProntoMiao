import { Component, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
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

@Component({
  selector: 'app-login-component',
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
  templateUrl: './login-component.component.html',
  styleUrl: './login-component.component.scss',
})
export class LoginComponentComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }


  /**
   * Returns the name of the control.
   *
   * @param {AbstractControl} control - the control for which the name is needed
   * @return {string} the name of the control
   */
  getControlName(control: AbstractControl): string {
    const parent = control.parent;
    const formGroup = parent as FormGroup;
    return (
      Object.keys(formGroup.controls).find(
        (key) => control === formGroup.get(key)
      ) || ''
    );
  }

  /**
   * Returns an error message based on the type of control and its validation errors.
   *
   * @param {AbstractControl} control - the form control to check for errors
   * @return {string} the error message based on the control's validation errors
   */
  getErrorMessage(control: AbstractControl) {
    if (this.getControlName(control) == 'email'){
      if (control.hasError('required')) {
        return 'Devi inserire una Email!';
      }

    return control.hasError('email') ? 'Email non valida!' : '';
  }else{
      if (control.hasError('required')) {
        return 'Devi inserire una Password!';
      }

      return 'Devi inserire una Password!';

  }
  }
}
