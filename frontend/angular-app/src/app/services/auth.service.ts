import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable, tap} from "rxjs";

const AUTH_API = 'http://localhost:8080/api/auth/'

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isLoggedIn = new BehaviorSubject<boolean>(false);
  isLoggedIn = this._isLoggedIn.asObservable();

  constructor(private http: HttpClient) {
    const token = localStorage.getItem('token')
    this._isLoggedIn.next(!!token);
  }

  login(credentials: { email: any; password: any; }): Observable<any> {
    return this.http.post(AUTH_API + 'login' ,{
      email: credentials.email,
      password: credentials.password
    }, httpOptions).pipe(
      tap((response: any) => {
        localStorage.setItem('token', response.token)
        this._isLoggedIn.next(true);
      })
    );
  }

  register(user: { /*name: any;*/ email: any; password: any; }): Observable<any> {
    return this.http.post(AUTH_API + 'register', {
      //name: user.name,
      email: user.email,
      password: user.password
    }, )
  }
}
