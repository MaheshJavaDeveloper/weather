package com.zooplus.app.model;

import java.util.List;

import lombok.Data;

@Data
public class Hourly {
    public int dt;
    public int temp;
    public int feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double uvi;
    public int clouds;
    public int visibility;
    public double wind_speed;
    public int wind_deg;
    public double wind_gust;
    public List<Weather> weather;
    public double pop;
}
