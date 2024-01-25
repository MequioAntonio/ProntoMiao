import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SegnalationFormComponent } from './pages/segnalation-form/segnalation-form.component';
import { AdoptionFormComponent } from './pages/adoption-form/adoption-form.component';
import { HomeComponent } from './pages/home/home.component';
import { AnimalInfoComponent } from './pages/animal-info/animal-info.component';
import { AnimalCardComponent } from './components/animal-card/animal-card.component';
import { ProfilepageComponent } from './profilepage/profilepage.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { CenterProfilePrivateComponent } from './center-profile-private/center-profile-private.component';
import { CenterProfilePublicComponent } from './center-profile-public/center-profile-public.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'login', component: LoginComponent },
  { path: 'adoption-form', component: AdoptionFormComponent },
  { path: 'segnalation-form', component: SegnalationFormComponent },
  { path: 'card', component: AnimalCardComponent },
  { path: 'info/:idAnnuncio', component: AnimalInfoComponent },
  { path: 'profile', component: ProfilepageComponent},
  { path: 'userhome', component : UserhomeComponent},
  { path: 'centerprofile', component: CenterProfilePublicComponent},
  { path: 'private', component: CenterProfilePrivateComponent}

];
