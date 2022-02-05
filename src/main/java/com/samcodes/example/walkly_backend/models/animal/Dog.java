package com.samcodes.example.walkly_backend.models.animal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.samcodes.example.walkly_backend.models.Booking;
import com.samcodes.example.walkly_backend.models.UserBase;
import com.samcodes.example.walkly_backend.models.person.Owner;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dogs")
public class Dog extends UserBase {

    @Column(name = "breed")
    private String breed;

    @Column(name = "size")
    private dogSize size;

    @ManyToOne
    @JsonIgnoreProperties({"dogs"})
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @JsonIgnoreProperties({"dogs"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "dogs_bookings",
            joinColumns = {@JoinColumn(name = "dog_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)})
    private List<Booking> bookings;

    public Dog() {
    }

    public Dog(String name, String breed, dogSize size, Owner owner) {
        super(name);
        this.breed = breed;
        this.size = size;
        this.owner = owner;
        this.bookings = new ArrayList<>();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public dogSize getSize() {
        return size;
    }

    public void setSize(dogSize size) {
        this.size = size;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
