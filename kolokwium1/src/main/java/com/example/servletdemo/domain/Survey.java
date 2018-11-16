package com.example.servletdemo.domain;

import java.util.List;

public class Survey {
	
	private long id;
	private String from;
	private String to;
	private String frequency;
	private List<String> comments;
	
	public Survey(long id, String from, String to, String frequency, List<String> comments) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.frequency = frequency;
		this.comments = comments;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
}
