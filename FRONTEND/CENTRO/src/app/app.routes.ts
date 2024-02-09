import { Routes } from '@angular/router';
//import { LoginComponent } from './pages/login/login.component';
//import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SegnalationFormComponent } from './pages/segnalation-form/segnalation-form.component';
import { AdoptionFormComponent } from './pages/adoption-form/adoption-form.component';
import { HomeComponent } from './pages/home/home.component';
import { AnimalInfoComponent } from './pages/animal-info/animal-info.component';
import { ProfilepageComponent } from './pages/profilepage/profilepage.component';
import { CenterProfilePrivateComponent } from './pages/center-profile-private/center-profile-private.component';
import { CenterProfilePublicComponent } from './pages/center-profile-public/center-profile-public.component';
import { AdoptionsPageComponent } from './pages/adoptions-page/adoptions-page.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { ReviewFormComponent } from './pages/review-form/review-form.component';
import { SegnalationsPageComponent } from './pages/segnalations-page/segnalations-page.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
 // { path: 'signup', component: SignUpComponent },
  //{ path: 'login', component: LoginComponent },
  { path: 'adoption-form', component: AdoptionFormComponent },
  { path: 'segnalation-form', component: SegnalationFormComponent },
  { path: 'annuncio/:idAnnuncio', component: AnimalInfoComponent },
  { path: 'profile/:idUtente', component: ProfilepageComponent},
  { path: 'centerprofile/:idCentro', component: CenterProfilePublicComponent},
  { path: 'private/:idCentro', component: CenterProfilePrivateComponent},
  { path: 'adoptions', component: AdoptionsPageComponent},
  { path: 'segnalations', component: SegnalationsPageComponent},
  { path: 'animal-info/:idCentro', component: AnimalInfoComponent},
  { path: 'review-form/:idCentro', component: ReviewFormComponent },
  { path: '404', component: NotFoundComponent},
  { path : '**', redirectTo: '404'}

];
