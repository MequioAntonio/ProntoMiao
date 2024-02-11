import { Injectable } from '@angular/core';
import { AbstractControl, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ValidatorsService {

  constructor() { }

  static passwordValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      const password: string = control.value;

      if (!/(?=.*[A-Z])/.test(password)) {
        return { uppercase: true };
      }

      if (!/(?=.*[a-z])/.test(password)) {
        return { lowercase: true };
      }

      if (!/(?=.*\d)/.test(password)) {
        return { digit: true };
      }

      if (!/(?=.*[!@#$%^&*])/.test(password)) {
        return { symbol: true };
      }

      return null; // Password is valid
    };
  }

  static emailValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      const email: string = control.value;
      const emailPattern: RegExp = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]+$/;

      if (!emailPattern.test(email)) {
        return { invalidEmail: true };
      }

      return null; // Email is valid
    };
  }


}
