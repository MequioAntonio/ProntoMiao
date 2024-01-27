import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SegnalationFormComponent } from './pages/segnalation-form/segnalation-form.component';
import { AdoptionFormComponent } from './pages/adoption-form/adoption-form.component';
import { HomeComponent } from './pages/home/home.component';
import { AnimalInfoComponent } from './pages/animal-info/animal-info.component';
import { AnimalCardComponent } from './components/animal-card/animal-card.component';
import { ProfilepageComponent } from './pages/profilepage/profilepage.component';
import { UserhomeComponent } from './pages/userhome/userhome.component';
import { CenterProfilePrivateComponent } from './pages/center-profile-private/center-profile-private.component';
import { CenterProfilePublicComponent } from './pages/center-profile-public/center-profile-public.component';
import { AdoptionsPageComponent } from './pages/adoptions-page/adoptions-page.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { CenterhomeComponent } from './pages/centerhome/centerhome.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adoption-form', component: AdoptionFormComponent },
  { path: 'segnalation-form', component: SegnalationFormComponent },
  { path: 'card', component: AnimalCardComponent },
  { path: 'annuncio/:idAnnuncio', component: AnimalInfoComponent },
  { path: 'profile/:idUtente', component: ProfilepageComponent},
  { path: 'userhome', component : UserhomeComponent},
  { path: 'centerhome', component: CenterhomeComponent},
  { path: 'centerprofile/:idCentro', component: CenterProfilePublicComponent},
  { path: 'private/', component: CenterProfilePrivateComponent},
  { path: 'adoptions', component: AdoptionsPageComponent},
  { path: '404', component: NotFoundComponent},
  { path : '**', redirectTo: '404'} 

];
