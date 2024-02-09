import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { HomeComponent } from './pages/home/home.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';



export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'login', component: LoginComponent },
 // { path: 'adoption-form', component: AdoptionFormComponent },
 // { path: 'segnalation-form', component: SegnalationFormComponent },
 // { path: 'annuncio/:idAnnuncio', component: AnimalInfoComponent },
 // { path: 'profile/:idUtente', component: ProfilepageComponent},
 // { path: 'centerprofile/:idCentro', component: CenterProfilePublicComponent},
 // { path: 'private/:idCentro', component: CenterProfilePrivateComponent},
 // { path: 'adoptions', component: AdoptionsPageComponent},
 // { path: 'segnalations', component: SegnalationsPageComponent},
 // { path: 'animal-info/:idCentro', component: AnimalInfoComponent},
 // { path: 'review-form/:idCentro', component: ReviewFormComponent },
  { path: '404', component: NotFoundComponent},
  { path : '**', redirectTo: '404'}

];
