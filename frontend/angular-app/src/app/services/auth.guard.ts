import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private auth: AuthService) {
  }

  canActivate() {
    if(!(this.auth.isLoggedIn)){
      return true;
    }else{
      window.alert('Permission denied for this page')
      return false;
    }
  }

}
