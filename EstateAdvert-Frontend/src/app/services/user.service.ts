import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = 'http://localhost:8080/api/v1/auth';
  constructor(private http: HttpClient,) { }

  login(email:String,password:String){
    return this.http.post(`${this.url}/authenticate`
    ,{email:email,password:password})
  }

}
