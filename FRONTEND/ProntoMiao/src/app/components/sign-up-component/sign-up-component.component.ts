import { Component } from '@angular/core';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckbox } from '@angular/material/checkbox';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-sign-up-component',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatSelectModule, MatCheckbox, MatButton],
  templateUrl: './sign-up-component.component.html',
  styleUrl: './sign-up-component.component.scss',
})
export class SignUpComponentComponent {}
