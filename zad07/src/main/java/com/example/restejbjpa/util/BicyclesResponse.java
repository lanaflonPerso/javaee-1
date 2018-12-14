package com.example.restejbjpa.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.restejbjpa.domain.Bicycle;

@XmlRootElement
public class BicyclesResponse {
	
	private List<Bicycle> bicycle;

	public List<Bicycle> getBicycle() {
		return bicycle;
	}

	public void setBicycle(List<Bicycle> bicycle) {
		this.bicycle = bicycle;
	}

}
