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
import { Router } from '@angular/router';
import { MatDialog, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle } from '@angular/material/dialog';

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
      return "Iscriviti";
    }
  }

  getIdUtente(){
    console.log(this.authService.getIdUtente());
    return this.authService.getIdUtente();

  }
  profilepage(){
    let id : any = this.getIdUtente();
    console.log("L'id è" + id);
    if (this.authService.getTipoUtente() == "PRIVATO") {
      this.router.navigate(['profile/' + id]);
    } else if(this.authService.getTipoUtente() == "CENTRO") {
      this.router.navigate(['private/' + id]);
  }
}

homepage(){
  let id : any = this.getIdUtente();
  console.log("L'id è" + id);
  if (this.authService.getTipoUtente() == "PRIVATO") {
    this.router.navigate(['userhome']);
  } else if(this.authService.getTipoUtente() == "CENTRO") {
    this.router.navigate(['centerhome']);
}
}

  logoutUser() {
    this.authService.logout();
  }
  title = 'ProntoMiao';
  searchValue: string = "";

  constructor(private authService: AuthService, private router: Router, public dialog: MatDialog) {}

  openMissionDialog(){
    this.dialog.open(DiaologMissione);
  }

  openChiDialog(){
    this.dialog.open(DiaologChiSiamo);
  }
}

@Component({
  selector: 'dialog-chisiamo',
  templateUrl: 'dialog-chisiamo.html',
  standalone: true,
  imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule],
})
export class DiaologChiSiamo {}


@Component({
  selector: 'dialog-missione',
  templateUrl: 'dialog-missione.html',
  standalone: true,
  imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule],
})
export class DiaologMissione {}
