import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Advert} from "../advert";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdvertService {
  private url = 'http://localhost:8080/api/v1/advert';

  constructor(private http:HttpClient) { }

  public getAdvert() {
    return this.http.get(`${this.url}/getAll`);
  }

  public createAdvert(advert: Advert): Observable<Advert> {
    return this.http.post<Advert>(`${this.url}/add`, advert);
  }

  public updateAdvert(advert: Advert): Observable<Advert> {
    return this.http.put<Advert>(`${this.url}/update`, advert);
  }

  public deleteAdvert(advertId: number) {
    return this.http.delete(`${this.url}/delete/${advertId}`);
  }
}
