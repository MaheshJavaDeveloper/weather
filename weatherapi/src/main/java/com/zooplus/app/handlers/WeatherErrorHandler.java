package com.zooplus.app.handlers;

import java.io.IOException;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WeatherErrorHandler implements ResponseErrorHandler  {

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (
		          httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
		          || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		if (httpResponse.getStatusCode()
		          .series() == HttpStatus.Series.SERVER_ERROR) {
		            // handle SERVER_ERROR
		        } else if (httpResponse.getStatusCode()
		          .series() == HttpStatus.Series.CLIENT_ERROR) {
		            // handle CLIENT_ERROR
		            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
		               log.error("Results not found for the given request. Please retry with new city");
		            }
		        }
		
	}	

	
	
}
