import { Routes } from '@angular/router';
import { SignUpComponentComponent } from './components/sign-up-component/sign-up-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { InserimentoSegnalazioneComponent } from './components/inserimento-segnalazione/inserimento-segnalazione.component';


export const routes: Routes = [
  { path: 'home', component: HomeComponentComponent },
  { path: 'signup', component: SignUpComponentComponent },
  { path: 'login', component: LoginComponentComponent },
  { path: 'inserimento-segnalazione', component: InserimentoSegnalazioneComponent }
];
