import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { NotesComponent } from './notes/notes.component';
const routes: Routes = [{path:'', redirectTo:'home', pathMatch:'full'}, /** If the path is empty, it will redirect to login page */
{path: 'login', component:LoginComponent},
{path: 'signup', component:SignupComponent},
{path: 'home', component:HomeComponent},
{path: 'notes', component:NotesComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
