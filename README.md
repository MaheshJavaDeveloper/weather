# Project: Weather Portal (Zooplus)
This portal is built to show current weather and historical weather status for the given city using the search bar provided in the application.
![image](https://user-images.githubusercontent.com/61374040/139161797-42fa0ccb-94fd-4e75-b1c9-840d2f6a63de.png)

## Front End Application - [Weather UI](https://github.com/MaheshJavaDeveloper/zooplus/tree/develop/weatherui) (Angular)
Front end application is built using angular and also used additional frameworks below to achieve the requirements.
This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 12.2.11
### Build and Run
* Run `npm install` and `ng build` to build the project.
* Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.
### Frameworks incorporated
1. NodeJs
2. Angular 12 
3. Bootstrap
4. Jquery
5. Font-awesome and Open Weather Icons
## Back End Application - [Weather API](https://github.com/MaheshJavaDeveloper/zooplus/tree/develop/weatherapi) (Java)
Back end application is built using Java 11 and SpringBootFramework to achieve the requirements.
### Build and Run
* Run `mvn clean install` to build the project.
* Run as `Spring Boot App`. Once the application started successfully in port `8080` Navigate to `http://localhost:8080/weathers/zagreb`.
### Technical Stack
1. Java 11
2. Spring Boot
3. Maven
4. Lombok
5. Junit
### Junit Test Cases
Added all the possible test cases to perform the Unit Test Cases in the application.
![image](https://user-images.githubusercontent.com/61374040/139165456-ba86952d-ee24-4658-9e8d-bab4412a1b76.png)

## User Guide to get weather status
#### Home Page
![image](https://user-images.githubusercontent.com/61374040/139163146-1bd5ad37-4942-4bde-a34e-1585ab31b64e.png)
#### Now please enter any valid city and click Get Weather Button near the search bar.
![image](https://user-images.githubusercontent.com/61374040/139163276-7a9812f2-501f-42e8-ac7c-8305b9d973bd.png)
#### Error Pages
##### If User submit empty values
![image](https://user-images.githubusercontent.com/61374040/139163349-2a989971-2d1d-449f-9a20-90263ec68f37.png)
##### If User enter invalid city
![image](https://user-images.githubusercontent.com/61374040/139163433-13de4db8-3366-46c9-a367-cc219b6559cf.png)
##### If backend services are not running or issues with data provider
![image](https://user-images.githubusercontent.com/61374040/139163671-eb50d180-1b7f-4b0f-954c-7898f8467198.png)
### Implementations Notes
 * Temperatures are shown in integers as expected.
 * Added Feels like, Humidity, Wind additionally to utilize api more and to provide more info to the users.
 * Added Hourly Forecast Weather i.e for upcoming 7hours from current time along with Current weather and Next 7 Days Forecast tab.
 * Increased 5 days forecast to 7 (Slight change from wireframe) to achieve one complete upcoming week.
 * Have slightly changed the design from the wireframe which was given in the task just to achieve a few more user-friendly experiences.
 * Added Digital Clock under Search bar as additional info to the user.
 * Results panel background will have two variations.
    1. Warm background for temperature above 20°c
    2. Cool background for temperature below 20°C

 

