import { Injectable } from '@angular/core';
import {BehaviorSubject, tap} from "rxjs";
import {UserService} from "./user.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  private readonly TOKEN_NAME = 'Authorization';
  isLoggedIn$ = this._isLoggedIn$.asObservable();

  get token(): any {
    return localStorage.getItem(this.TOKEN_NAME);
  }

  constructor(private userService: UserService) {
    this._isLoggedIn$.next(!!this.token);
  }

  login(email: string, password: string) {
    return this.userService.login(email, password).pipe(
      tap((response: any) => {
        this._isLoggedIn$.next(true);
        localStorage.setItem(this.TOKEN_NAME, `Bearer ${response.token}`);
      })
    );
  }
}
