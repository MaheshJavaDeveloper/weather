package com.zooplus.app.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zooplus.app.handlers.CustomClientHttpRequestInterceptor;
import com.zooplus.app.handlers.WeatherErrorHandler;

@Service
public class RestTempalteBuilder {

	public RestTemplate createRestTempalte() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new WeatherErrorHandler());
		restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
		return restTemplate;
	}

}
