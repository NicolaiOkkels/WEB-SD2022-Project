import { Trip } from '../models/trip';
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: "root"
})
export class TripService{
  private apiServerUrl = environment.apiBaseUrl

  constructor(private http: HttpClient) {}

  public getTrips(): Observable<Trip[]>{
    return this.http.get<Trip[]>(`${this.apiServerUrl}/api/trips/`)
  }

  public addTrip(trip: { duration: StringConstructor | null | undefined; price: NumberConstructor | null | undefined; rating: number; description: StringConstructor | null | undefined; availability: StringConstructor | null | undefined; title: StringConstructor | null | undefined }): Observable<Trip>{
    return this.http.post<Trip>(`${this.apiServerUrl}/api/trips/add`, trip);
  }
}
