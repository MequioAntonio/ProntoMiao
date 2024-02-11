import { Routes } from '@angular/router';
import { AdoptionFormComponent } from './pages/adoption-form/adoption-form.component';
import { HomeComponent } from './pages/home/home.component';
import { CenterProfilePrivateComponent } from './pages/center-profile-private/center-profile-private.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { SegnalationsPageComponent } from './pages/segnalations-page/segnalations-page.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'adoption-form', component: AdoptionFormComponent },
  { path: 'private/:idCentro', component: CenterProfilePrivateComponent},
  { path: 'segnalations', component: SegnalationsPageComponent},
  { path: '404', component: NotFoundComponent},
  { path : '**', redirectTo: '404'}

];
