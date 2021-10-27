package com.zooplus.app.model;

import java.util.List;

import lombok.Data;

@Data
public class WeatherHistoryData {
	public double lat;
	public double lon;
	public String timezone;
	public int timezone_offset;
	public List<Daily> daily;
	public List<Hourly> hourly;
	public List<Alert> alerts;
}
