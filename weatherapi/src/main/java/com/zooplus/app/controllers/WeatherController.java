package com.zooplus.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zooplus.app.rest.WeatherRestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WeatherController {

	@Autowired
	WeatherRestTemplate weatherRestTemplate;

	@GetMapping(path = "weathers/{city}")
	public String validate(@PathVariable String city) {

		return weatherRestTemplate.weatherAPI(city);

	}

}