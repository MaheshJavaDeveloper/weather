package com.zooplus.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zooplus.app.model.WeatherData;
import com.zooplus.app.model.WeatherHistoryData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Configuration
public class WeatherRestTemplate {

	@Value("${open.weather.api}")
	public String openWeatherApi;

	@Value("${api.key}")
	public String apiKey;

	@Autowired
	private RestTempalteBuilder restTempalteBuilder;

	/**
	 * 
	 * @param city
	 * @return
	 */
	public WeatherData weatherAPI(String city) {
		RestTemplate restTemplate = restTempalteBuilder.createRestTempalte();
		String weatherAPI = openWeatherApi + "weather?q=" + city + "&units=metric&appid=" + apiKey;
		ResponseEntity<WeatherData> response = restTemplate.getForEntity(weatherAPI, WeatherData.class);
		log.info("Completed processing weather for city: {}", city);
		return response.getBody();
	}

	/**
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 */
	public WeatherHistoryData weatherHistoricalAPI(String lat, String lon) {
		RestTemplate restTemplate = restTempalteBuilder.createRestTempalte();
		String weatherAPI = openWeatherApi + "onecall?lat=" + lat + "&lon=" + lon + "&units=metric&appid=" + apiKey;
		ResponseEntity<WeatherHistoryData> response = restTemplate.getForEntity(weatherAPI, WeatherHistoryData.class);
		log.info("Completed processing history weather for city lat: {} and lon: {}", lat,lon);
		return response.getBody();
	}

}
