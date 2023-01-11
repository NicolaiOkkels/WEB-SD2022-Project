import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/auth.service";
import {User} from "./models/user";
import {HttpErrorResponse} from "@angular/common/http";
import {TripService} from "./services/trip.service";
import {Trip} from "./models/trip";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public trips: Trip[] = [];

  tripForm = new FormGroup({
    title: new FormControl(null),
    description: new FormControl(null),
    price: new FormControl(null),
    duration: new FormControl(null),
    availability: new FormControl(null)
  });

  public isLoggedIn = this.authService.isLoggedIn

  constructor(public authService: AuthService, private tripService: TripService) {

  }

  ngOnInit() {
    //this.homepage = true;
    this.getTrips();
  }

  submitForm(){

    const tripInfo = {title: this.tripForm.get('title')?.value,
      description: this.tripForm.get('description')?.value,
      price: this.tripForm.get('price')?.value,
      duration: this.tripForm.get('duration')?.value,
      availability: this.tripForm.get('availability')?.value,
      rating: 0}

    console.log(tripInfo);

    this.tripService.
      addTrip(tripInfo).
      subscribe((response) => {
        console.log(response)
    });
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
