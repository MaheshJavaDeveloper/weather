package com.zooplus.app.model;

import java.util.List;

import lombok.Data;

@Data
public class Alert {
	 public String sender_name;
	 public String event;
	 public int start;
	 public int end;
	 public String description;
	 public List<String> tags;
	}