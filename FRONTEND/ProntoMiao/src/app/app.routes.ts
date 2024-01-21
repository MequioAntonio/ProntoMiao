import { Routes } from '@angular/router';
import { SignUpComponentComponent } from './components/sign-up-component/sign-up-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { HomeComponentComponent } from './components//home-component/home-component.component';

export const routes: Routes = [
    {path: 'home', component : HomeComponentComponent},
    {path: 'signup', component : SignUpComponentComponent},
    {path: 'login', component : LoginComponentComponent}






];
