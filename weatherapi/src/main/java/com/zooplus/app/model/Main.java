package com.zooplus.app.model;

import lombok.Data;

@Data
public class Main {
    public int temp;
    public int feels_like;
    public int temp_min;
    public int temp_max;
    public int pressure;
    public int humidity;
}
