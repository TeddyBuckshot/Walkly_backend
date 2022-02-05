package com.samcodes.example.walkly_backend.models.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.samcodes.example.walkly_backend.models.Booking;
import com.samcodes.example.walkly_backend.models.UserBase;
import com.samcodes.example.walkly_backend.models.animal.Dog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner extends UserBase {

    @Column(name = "bio")
    private String bio;

    @Column(name = "rating")
    private int rating;

    @JsonBackReference
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @JsonBackReference
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Dog> dogs;

    public Owner() {
    }

    public Owner(String name, String bio, int rating) {
        super(name);
        this.bio = bio;
        this.rating = rating;
        this.bookings = new ArrayList<>();
        this.dogs = new ArrayList<>();
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

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}