import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginPageComponent} from "./login-page/login-page.component";
import {AdvertPageComponent} from "./advert-page/advert-page.component";
import {IsAuthenticatedGuard} from "./isAuthenticated.guard";

const routes: Routes = [
  {path:"",component:LoginPageComponent},
  {path:"login",component:LoginPageComponent},
  {path:"advert",component:AdvertPageComponent, canActivate:[IsAuthenticatedGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
