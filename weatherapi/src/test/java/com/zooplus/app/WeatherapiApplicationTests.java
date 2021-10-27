package com.zooplus.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zooplus.app.model.WeatherData;
import com.zooplus.app.model.WeatherHistoryData;
import com.zooplus.app.rest.WeatherRestTemplate;

@SpringBootTest
class WeatherapiApplicationTests {

	@Autowired
	WeatherRestTemplate weatherRestTemplate;

	/**
	 * @author maheshkumar.m
	 * @description Testing the weather API when application is started and running.
	 * @disabled
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	@Disabled
	void testWeatherRestAPI() throws IOException, InterruptedException {
		// This can be tested only the application is up and running so - Disabled.
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/weathers/zagreb")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		assertThat(response.statusCode()).isEqualTo(200);
	}

	/**
	 * @author maheshkumar.m
	 * @description Testing the weather API returns proper city and country code.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	void testWeatherAPIforCityZagreb() throws IOException, InterruptedException {
		WeatherData weatherData = weatherRestTemplate.weatherAPI("Zagreb");
		assertThat(weatherData.getName()).isEqualTo("Donji grad");
		assertThat(weatherData.getSys().getCountry()).isEqualTo("HR");
	}

	/**
	 * @author maheshkumar.m
	 * @description (Negative Case) Testing the weather API returns null for improper city comes as request.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	void testWeatherAPIforUnknownCity() throws IOException, InterruptedException {
		WeatherData weatherData = weatherRestTemplate.weatherAPI("notavalidcity");
		assertThat(weatherData.getName()).isEqualTo(null);
	}

	/**
	 * @author maheshkumar.m
	 * @description (Negative Case) Testing the weather API returns null for empty request.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	void testWeatherAPIforEmptyCity() throws IOException, InterruptedException {
		WeatherData weatherData = weatherRestTemplate.weatherAPI(" ");
		assertThat(weatherData.getName()).isNull();
	}

	/**
	 * @author maheshkumar.m
	 * @description Testing the weather API for Historical data for the coords lat:55.3047 and lon:25.2582.
	 * @disabled
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	void testHistoryWeatherAPIforCity() throws IOException, InterruptedException {
		WeatherHistoryData weatherData = weatherRestTemplate.weatherHistoricalAPI("55.3047", "25.2582");
		assertThat(weatherData.getLat()).isEqualTo(55.3047);
		assertThat(weatherData.getLon()).isEqualTo(25.2582);
	}

	/**
	 * @author maheshkumar.m
	 * @description (Negative Case) Testing the weather API returns null for improper coords.
	 * @disabled
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	void testHistoryWeatherAPIforUnknownCity() throws IOException, InterruptedException {
		WeatherHistoryData weatherData = weatherRestTemplate.weatherHistoricalAPI("dummy1", "dummy2");
		assertThat(weatherData.getDaily()).isEqualTo(null);
	}

	/**
	 * @author maheshkumar.m
	 * @description (Negative Case) Testing the weather API returns null for empty request.
	 * @disabled
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	void testHistoryWeatherAPIforEmpty() throws IOException, InterruptedException {
		WeatherHistoryData weatherData = weatherRestTemplate.weatherHistoricalAPI("", "");
		assertThat(weatherData.getDaily()).isEqualTo(null);
	}

}
