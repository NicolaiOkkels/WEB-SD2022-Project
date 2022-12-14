import { Component } from '@angular/core';
import {Trip} from "./models/trip";
import {TripService} from "./services/trip.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
}
