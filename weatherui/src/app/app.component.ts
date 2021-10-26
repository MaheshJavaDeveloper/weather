import { Component} from '@angular/core';
import { WeatherapiService } from '../app/service/weatherapi.service';
import iconJson from '../assets/icons/weatherIcons.json';
import { Icon } from './model/icon.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  public now: Date = new Date();
  city: string = "";
  weatherData: any;
  resultPannelShow: boolean = false;
  errorPannelShow: boolean = false;
  resultsCity: string = "";
  icon: string = "";
  weatherIcons: Icon[] = iconJson;
  bgClear: boolean = false;
  bgCloudy: boolean = false;
  weatherHistoryDataDaily: any;
  weatherHistoryDataHourly?: any;

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
          this.icon = weatherDataResp.weather[0].icon;
          if (weatherDataResp.weather[0].main == 'Clear') {
            this.bgClear = true;
            this.bgCloudy = false;
          } else {
            this.bgClear = false;
            this.bgCloudy = true;
          }
          this.weatherapiService.getWeatherHistory(weatherDataResp.coord.lat, weatherDataResp.coord.lon).subscribe((weatherHistoryDataResp:any) => {
            
            this.weatherHistoryDataDaily=weatherHistoryDataResp.daily.slice(0,7);
            this.weatherHistoryDataHourly=weatherHistoryDataResp.hourly.slice(0,7);
          });
          this.errorPannelShow = false;
          this.resultPannelShow = true;
        } else {
          this.resultsCity = 'No City with ' + city + ' found !!! Please check if the spelling is correct.';
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
