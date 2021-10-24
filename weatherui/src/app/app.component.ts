import { Component } from '@angular/core';
import { WeatherapiService } from '../app/service/weatherapi.service';
import { WeatherData } from './interface/WeatherData'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public now: Date = new Date();
  city: string = "";
  weatherData: any;
  resultPannelShow: boolean = false;
  errorPannelShow: boolean = false;
  resultsCity: string = "";

  constructor(private weatherapiService: WeatherapiService) {
    setInterval(() => {
      this.now = new Date();
    }, 1);
  }

  toggleShow(city: string) {
    if (city) {
      this.weatherapiService.getWeather(city).subscribe((weatherDataResp: any) => {
        if (weatherDataResp.main) {
          this.weatherData = weatherDataResp;
          this.errorPannelShow = false;
          this.resultPannelShow = true;
        } else {
          this.resultsCity = 'No City with ' +city+' found !!! Please check if the spelling is correct.';
          this.resultPannelShow = false;
          this.errorPannelShow = true;
        }
      });
    } else {
      this.resultsCity = 'No City entered !!! Please type any vaild City.';
      this.resultPannelShow = false;
      this.errorPannelShow = true;
    }    
  }
}
