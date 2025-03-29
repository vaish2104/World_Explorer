import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Recommended } from 'src/app/recommended';

@Injectable({
  providedIn: 'root'
})
// service to access all the backend api's of recommended microservice
export class RecommmendedService {

  //dependency injection of HttpClient
  constructor(private http: HttpClient) { }
  
  //Get method to get all the users which passes the recommended criterea
  getData(token: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8003/api/recom`, {
      headers: new HttpHeaders().set("Authorization", `Bearer ${token}`)
    }).pipe(
      map(
        userData => {
          return userData;
        }));
  }

  // Post method to add recommended so that the counter can increase by 1
  addData(recom: Recommended, token: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8003/api/recom`, recom, {
      headers: new HttpHeaders().set("Authorization", `Bearer ${token}`)
    }).pipe(
      map(
        userData => {
          return userData;
        }));
  }

  //delete method to delete recommended so that the counter will be decremented by 1
  deleteData(pid: number, token: string): Observable<any> {
    return this.http.delete<any>(`http://localhost:8003/api/recom?id=${pid}`, {
      headers: new HttpHeaders().set("Authorization", `Bearer ${token}`)
    }).pipe(
      map(
        userData => {
          return userData;
        }));
  }

}
