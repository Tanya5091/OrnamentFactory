import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {ReactiveFormsModule} from '@angular/forms';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {HomeComponent} from './home/home.component';
import {MaterialsTableComponent} from './materials-table/materials-table.component';
import {MatTableModule} from '@angular/material/table';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { OrderCardComponent } from './order-card/order-card.component';
import { WorkerPageComponent } from './worker-page/worker-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MaterialsTableComponent,
    RegisterComponent,
    HeaderComponent,
    OrderCardComponent,
    WorkerPageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    MatTableModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
