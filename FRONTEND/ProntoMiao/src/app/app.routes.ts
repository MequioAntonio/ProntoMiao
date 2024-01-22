import { Routes } from '@angular/router';
import { SignUpComponentComponent } from './components/sign-up-component/sign-up-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { InserimentoSegnalazioneComponent } from './components/inserimento-segnalazione/inserimento-segnalazione.component';
import { AnimalPostComponentComponent } from './components/animal-post-component/animal-post-component.component';
import { InserimentoAnnuncioComponentComponent } from './components/inserimento-annuncio-component/inserimento-annuncio-component.component';
export const routes: Routes = [
  { path: 'home', component: HomeComponentComponent },
  { path: 'signup', component: SignUpComponentComponent },
  { path: 'login', component: LoginComponentComponent },
  { path: 'inserimento-segnalazione', component: InserimentoSegnalazioneComponent },
  { path: 'addadoption', component: InserimentoAnnuncioComponentComponent},
  { path: 'animalpost', component: AnimalPostComponentComponent}
];
