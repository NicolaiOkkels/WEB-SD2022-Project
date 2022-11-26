package com.sd22.dbproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trips")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private double price;
    private String duration;
    private String title;
    private String availability;
    private Double ratingTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("trip_location")
    private Location location;

    @OneToMany(mappedBy = "trip", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("trip_reviews")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "trip_tags",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonManagedReference("trip_tags")
    private Set<Tag> tags;

    public Trip() {
    }

    public Trip(String description, double price, String duration, String title, String availability, Double ratingTotal,
                Location location, List<Review> reviews, Set<Tag> tags) {
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.title = title;
        this.availability = availability;
        this.ratingTotal = ratingTotal;
        this.location = location;
        this.reviews = reviews;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int tripId) {
        this.id = tripId;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", length='" + duration + '\'' +
                ", title='" + title + '\'' +
                ", availabilty='" + availability + '\'' +
                ", ratingTotal=" + ratingTotal +
                '}';
    }
}
