package com.example.restejbjpa.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "producer.all", query = "Select p from Producer p"),
})
public class Producer {

    private long id;
    private String name;
    private List<Bicycle> bicycles = new ArrayList<Bicycle>();
    private Set<Address> addresses = new LinkedHashSet<Address>();

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
    @JsonIgnore
    public List<Bicycle> getBicycles() {
        return bicycles;
    }
    @JsonIgnore
    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }
	
	public void addBicycles(List<Bicycle> bicycles) {
		
		this.setBicycles(bicycles);
		
		for (Bicycle bicycle: bicycles){
			bicycle.getProducers().add(this);
		}
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producer", fetch = FetchType.EAGER)
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

}