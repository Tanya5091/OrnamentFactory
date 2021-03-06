import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
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
import { NewOrderFormComponent } from './new-order-form/new-order-form.component';
import { SalesManagerPageComponent } from './sales-manager-page/sales-manager-page.component';
import { UnitManagerPageComponent } from './unit-manager-page/unit-manager-page.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MenuModule} from 'primeng/menu';
import {MenuItem, MessageService} from 'primeng/api';
import {OrdersService} from "./servises/orders.service";
import {DropdownModule} from 'primeng/dropdown';
import {ButtonsModule, InputsModule, InputUtilitiesModule, ModalModule, WavesModule} from "angular-bootstrap-md";
import {DialogComponent} from "./dialog/dialog.component";
import {MatDialogModule} from "@angular/material/dialog";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MaterialsTableComponent,
    RegisterComponent,
    HeaderComponent,
    OrderCardComponent,
    WorkerPageComponent,
    NewOrderFormComponent,
    SalesManagerPageComponent,
    UnitManagerPageComponent,
    DialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    MatTableModule,
    HttpClientModule,
    MatFormFieldModule,
    MatSelectModule,
    MenuModule,
    DropdownModule,
    FormsModule,
    WavesModule,
    ButtonsModule,
    ModalModule.forRoot(),
    InputUtilitiesModule,
    InputsModule,
    MatDialogModule
  ],
  entryComponents: [DialogComponent],
  providers: [
    MessageService,
    OrdersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
