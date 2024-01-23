import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SegnalationFormComponent } from './pages/segnalation-form/segnalation-form.component';
import { AdoptionFormComponent } from './pages/adoption-form/adoption-form.component';
import { HomeComponent } from './pages/home/home.component';
import { AnimalInfoComponent } from './pages/animal-info/animal-info.component';
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
