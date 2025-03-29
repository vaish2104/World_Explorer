import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WorldapiService {
// dependency injection of HttpClient service
constructor(private http: HttpClient) { }



// Get method to search country with the help of Country Name
searchCountry(search: string): Observable<any> {
  return this.http.get(`https://restcountries.com/v3.1/name/${search}`, {
    
  });
}
// Get method to get the country details by country capital
searchByCapital(capital: string): Observable<any> {
  return this.http.get(`https://restcountries.com/v3.1/capital/${capital}`, {
    
    
  })
}
searchByRegion(region: string): Observable<any> {
  return this.http.get(`https://restcountries.com/v3.1/subregion/${region}`, {
    
    
  })
}
}

// https://restcountries.com/v3.1/region/europe