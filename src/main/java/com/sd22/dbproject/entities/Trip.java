package com.sd22.dbproject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
    private String description;
    private double price;
    private String duration;
    private String title;
    private String availability;
    private Double ratingTotal;

    public Trip() {
    }

    public Trip(String description, double price, String duration, String title, String availability, Double ratingTotal,
                Location location, List<Review> reviews) {
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.title = title;
        this.availability = availability;
        this.ratingTotal = ratingTotal;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String length) {
        this.duration = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availabilty) {
        this.availability = availabilty;
    }

    public Double getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(Double ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", length='" + duration + '\'' +
                ", title='" + title + '\'' +
                ", availabilty='" + availability + '\'' +
                ", ratingTotal=" + ratingTotal +
                '}';
    }
}
