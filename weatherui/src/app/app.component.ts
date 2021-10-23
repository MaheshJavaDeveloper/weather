import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  public now: Date = new Date();
  city: string = "";
  constructor() {
    setInterval(() => {
      this.now = new Date();
    }, 1);
  }

  resultPannelShow: boolean = false;
  toggleShow() {
    this.resultPannelShow = !this.resultPannelShow;
  }
}