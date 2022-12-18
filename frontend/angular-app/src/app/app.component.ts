import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/auth.service";
import {User} from "./models/user";
import {HttpErrorResponse} from "@angular/common/http";
import {TripService} from "./services/trip.service";
import {Trip} from "./models/trip";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public trips: Trip[] = [];

  constructor(public authService: AuthService, private tripService: TripService) {

  }

  ngOnInit() {
    this.getTrips();
  }

  public getTrips(): void {
    this.tripService.getTrips().subscribe({
      next: (response: Trip[]) => {
        this.trips = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
}
