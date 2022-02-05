package com.samcodes.example.walkly_backend.models.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.samcodes.example.walkly_backend.models.Booking;
import com.samcodes.example.walkly_backend.models.UserBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "walkers")
public class Walker extends UserBase {

    @Column(name = "businessName")
    private String businessName;

    @Column(name = "price")
    private double pricePerHour;

    @Column(name = "bio")
    private String bio;

    @Column(name = "rating")
    private int rating;

    @JsonIgnoreProperties({"walkers"})
    @OneToMany(mappedBy = "walker", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Walker() {
    }

    public Walker(String name, String businessName, double pricePerHour, String bio, int rating) {
        super(name);
        this.businessName = businessName;
        this.pricePerHour = pricePerHour;
        this.bio = bio;
        this.rating = rating;
        this.bookings = new ArrayList<>();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
