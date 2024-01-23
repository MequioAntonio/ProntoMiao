import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { SegnalationFormComponent } from './components/segnalation-form/segnalation-form.component';
import { AdoptionFormComponent } from './components/adoption-form/adoption-form.component';
import { HomeComponent } from './components/home/home.component';
import { AnimalInfoComponent } from './components/animal-info/animal-info.component';
import { AnimalCardComponent } from './components/animal-card/animal-card.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adoption-form', component: AdoptionFormComponent },
  { path: 'segnalation-form', component: SegnalationFormComponent },
  { path: 'card', component: AnimalCardComponent },
  { path: 'info/:idAnnuncio', component: AnimalInfoComponent },
];
