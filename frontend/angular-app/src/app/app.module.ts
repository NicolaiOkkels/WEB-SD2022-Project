import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
/*import {AdminComponent} from "./app.AdminComponent";*/
import {AdministratorComponent} from "./administrator/administrator.component";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,AdministratorComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        FormsModule,
        MatMenuModule,
        MatIconModule
    ],
  providers: [],
  bootstrap: [AdministratorComponent]
})
export class AppModule { }
