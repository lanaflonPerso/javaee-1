package com.example.restejbjpa.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.restejbjpa.domain.Bicycle;
import com.example.restejbjpa.domain.Producer;

@XmlRootElement
public class ProducersResponse {
	
	private List<Producer> producer;

	public List<Producer> getProducer() {
		return producer;
	}

	public void setProducer(List<Producer> producer) {
		this.producer = producer;
	}

}
