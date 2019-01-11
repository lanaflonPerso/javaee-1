package com.example.restejbjpa.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "producer.all", query = "Select p from Producer p"),
})
public class Producer {

    private long id;
    private String name;
    private List<Bicycle> bicycles = new ArrayList<Bicycle>();

    public Producer(String name) {
        this.name = name;
    }

    public Producer() {
    	
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Bicycle> getBicycles() {
        return bicycles;
    }
    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }
	
	public void addBicycles(List<Bicycle> bicycles) {
		
		this.setBicycles(bicycles);
		
		for (Bicycle bicycle: bicycles){
			bicycle.getProducers().add(this);
		}
	}

}