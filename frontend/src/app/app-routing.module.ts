import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {RegisterComponent} from "./register/register.component";
import {SalesManagerPageComponent} from "./sales-manager-page/sales-manager-page.component";
import {WorkerPageComponent} from "./worker-page/worker-page.component";
import {UnitManagerPageComponent} from "./unit-manager-page/unit-manager-page.component";

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'sales-manager', component: SalesManagerPageComponent},
  {path: 'worker-page', component: WorkerPageComponent},
  {path: 'unit-manager-page', component: UnitManagerPageComponent},

  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
