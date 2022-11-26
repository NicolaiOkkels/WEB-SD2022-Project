package com.sd22.dbproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name ="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JsonManagedReference("country_locations")
    private Set<Location> locations;

    public Country() {
    }

    public Country(String name, Set<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + id +
                ", name='" + name + '\'' +
                ", locations=" + locations
                +
                '}';
    }
}
