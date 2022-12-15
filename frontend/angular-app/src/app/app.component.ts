import { Component } from '@angular/core';
import {Trip} from "./models/trip";
import {TripService} from "./services/trip.service";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public authService: AuthService) {
  }
}
