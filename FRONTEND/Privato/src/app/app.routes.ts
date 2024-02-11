import { Routes } from '@angular/router';
import { SegnalationFormComponent } from './pages/segnalation-form/segnalation-form.component';
import { HomeComponent } from './pages/home/home.component';
import { AnimalInfoComponent } from './pages/animal-info/animal-info.component';
import { ProfilepageComponent } from './pages/profilepage/profilepage.component';
import { CenterProfilePublicComponent } from './pages/center-profile-public/center-profile-public.component';
import { AdoptionsPageComponent } from './pages/adoptions-page/adoptions-page.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { ReviewFormComponent } from './pages/review-form/review-form.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'segnalation-form', component: SegnalationFormComponent },
  { path: 'annuncio/:idAnnuncio', component: AnimalInfoComponent },
  { path: 'profile/:idUtente', component: ProfilepageComponent},
  { path: 'centerprofile/:idCentro', component: CenterProfilePublicComponent},
  { path: 'adoptions', component: AdoptionsPageComponent},
  { path: 'animal-info/:idCentro', component: AnimalInfoComponent},
  { path: 'review-form/:idCentro', component: ReviewFormComponent },
  { path: '404', component: NotFoundComponent},
  { path : '**', redirectTo: '404'}

];
