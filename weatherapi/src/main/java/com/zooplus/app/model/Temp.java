package com.zooplus.app.model;

import lombok.Data;

@Data
public class Temp {
	public int day;
	public int min;
	public int max;
	public int night;
	public int eve;
	public int morn;
}