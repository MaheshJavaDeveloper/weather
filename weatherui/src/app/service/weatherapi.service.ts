import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherData } from '../interface/WeatherData';

@Injectable({
  providedIn: 'root'
})
export class WeatherapiService {

  constructor(private http: HttpClient) { }

  getWeather(city : string): Observable <WeatherData>{
    return this.http.get<WeatherData>("http://localhost:8080/weathers/"+city);
  }
  getWeatherHistory(lat : string,lon : string) {
    return this.http.get("http://localhost:8080/weathers/"+lat+"/"+lon);
  }
}
