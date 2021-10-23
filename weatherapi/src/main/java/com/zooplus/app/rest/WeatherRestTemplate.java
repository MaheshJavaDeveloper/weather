package com.zooplus.app.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.zooplus.app.handlers.MyErrorHandler;

@Service
public class WeatherRestTemplate {

	public String weatherAPI(String city) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandler());

		String weatherAPI = "https://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&appid=6650d1e6da8402bf01dd54b8baf7a554";
		ResponseEntity<String> response;

		try {
			response = restTemplate.getForEntity(weatherAPI, String.class);
			return response.getBody();
		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			return " { city not found } ";
		}
	}

}
