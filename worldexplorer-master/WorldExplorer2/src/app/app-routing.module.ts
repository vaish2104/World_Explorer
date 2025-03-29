import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from 'src/app/login/login.component';
import { SignupComponent } from 'src/app/signup/signup.component';
import { DashboardComponent } from 'src/app/dashboard/dashboard.component';
import { SearchComponent } from 'src/app/search/search.component';
import { FavouritesComponent } from 'src/app/favourites/favourites.component';
import { RecommendedComponent } from 'src/app/recommended/recommended.component';
import { EdituserComponent } from 'src/app/edituser/edituser.component';

import { HomeComponent } from 'src/app/home/home.component';

const routes: Routes = [ // making the login as the default path of the app
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
    
  },
  //path to load login component
  {
    path:'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  // path to load the signup component
  {
    path: 'signup',
    component: SignupComponent
  },
  // path to login the dashboard component
  {
    path: 'dashboard',
    component: DashboardComponent,
    //once a user logs in he will be directed to login and will be able to access children paths
    children: [
      // making search as the default path of dashboard
      {
        path: '',
        redirectTo: 'search',
        pathMatch: 'full'
      },
      // path of search component
      {
        path: 'search',
        component: SearchComponent,
        
      },
      // path of stat component
      
      // path of favourites coomponent
      {
        path: 'favourites',
        component: FavouritesComponent
      },
      // path of recommended component
      {
        path: 'recommended',
        component:  RecommendedComponent
      },
      // path of edituser component
      {
        path: 'edit',
        component: EdituserComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
