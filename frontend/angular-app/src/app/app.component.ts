import { Component } from '@angular/core';
import {Trip} from "./trip";
import {TripService} from "./trip.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public trips: Trip[];

  constructor(private tripService: TripService) {}

  ngOnInit(){
    this.getTrip();
  }

  public getTrip(): void {
    this.tripService.getTrips().subscribe(
    (response: Trip[])=> {
      this.trips = response;
    },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
