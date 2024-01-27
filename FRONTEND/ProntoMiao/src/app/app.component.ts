import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink, RouterOutlet } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AuthService } from './services/auth.service';
import {FormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HttpClientModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    RouterLink,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  isLogged() {
    return this.authService.isLogged();
  }

  getTipoUtente() {
    if (this.authService.getTipoUtente() == "PRIVATO") {
      return "Privato";
    } else if(this.authService.getTipoUtente() == "CENTRO") {
      return "Centro adozioni";
    } else {
      return "COGLIONE";
    }
  }

  logoutUser() {
    this.authService.logout();
  }
  title = 'ProntoMiao';
  searchValue: string = "";

  constructor(private authService: AuthService) {}
}
