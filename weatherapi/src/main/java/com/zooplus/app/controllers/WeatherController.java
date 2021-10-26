package com.zooplus.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zooplus.app.model.WeatherData;
import com.zooplus.app.model.WeatherHistoryData;
import com.zooplus.app.rest.WeatherRestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200/")
public class WeatherController {

	@Autowired
	WeatherRestTemplate weatherRestTemplate;

	
	@GetMapping(path = "weathers/{city}")
	public WeatherData getWeatherByCity(@PathVariable String city) {		
		log.info("Started processing weather for city: {}",city);
		return weatherRestTemplate.weatherAPI(city);
	}
	
	@GetMapping(path = "weathers/{lat}/{lon}")
	public WeatherHistoryData getHistoricalWeatherByLadLong(@PathVariable String lat,@PathVariable String lon ) {
		
		log.info("Started processing history weather for lat: {} and lon : {}",lat,lon);
		return weatherRestTemplate.weatherHistoricalAPI(lat,lon);

	}

}
