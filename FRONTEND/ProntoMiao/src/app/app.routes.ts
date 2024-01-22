import { Routes } from '@angular/router';
import { SignUpComponentComponent } from './components/sign-up-component/sign-up-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { InserimentoSegnalazioneComponent } from './components/inserimento-segnalazione/inserimento-segnalazione.component';
import { InserimentoAnnuncioComponentComponent } from './components/inserimento-annuncio-component/inserimento-annuncio-component.component';
import {AnimalCardComponentComponent} from './components/animal-card-component/animal-card-component.component';
import { AnimalInfoComponentComponent } from './components/animal-info-component/animal-info-component.component';

export const routes: Routes = [
  { path: 'homepage', component: HomeComponentComponent },
  { path: 'signup', component: SignUpComponentComponent },
  { path: 'login', component: LoginComponentComponent },
  { path: 'addadoption', component: InserimentoAnnuncioComponentComponent},
  { path: 'addreport', component: InserimentoSegnalazioneComponent },
  { path: 'card', component: AnimalCardComponentComponent },
  { path: 'info', component: AnimalInfoComponentComponent},
];
