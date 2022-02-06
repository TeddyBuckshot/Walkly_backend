package com.samcodes.example.walkly_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.samcodes.example.walkly_backend.models.animal.Dog;
import com.samcodes.example.walkly_backend.models.person.Owner;
import com.samcodes.example.walkly_backend.models.person.Walker;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "lengthOfWalk")
    private int lengthOfWalk;

    @ManyToOne
    @JsonIgnoreProperties ({"bookings"})
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToOne
    @JsonIgnoreProperties ({"bookings"})
    @JoinColumn(name = "walker_id", nullable = false)
    private Walker walker;

    @ManyToMany
    @JsonIgnoreProperties(value = "bookings")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "dogs_bookings",
            joinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "dog_id", nullable = false, updatable = false)}
    )
    private List<Dog> chosenDogs;

    public Booking() {
    }

    public Booking(String startDate, String endDate, int lengthOfWalk, Owner owner, Walker walker) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.lengthOfWalk = lengthOfWalk;
        this.owner = owner;
        this.walker = walker;
        this.chosenDogs = new ArrayList<Dog>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getLengthOfWalk() {
        return lengthOfWalk;
    }

    public void setLengthOfWalk(int lengthOfWalk) {
        this.lengthOfWalk = lengthOfWalk;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Walker getWalker() {
        return walker;
    }

    public void setWalker(Walker walker) {
        this.walker = walker;
    }

    public List<Dog> getDogs() {
        return chosenDogs;
    }

    public void addDog(Dog dog){
        chosenDogs.add(dog);
    }

    public void setDogs(List<Dog> chosenDogs) {
        this.chosenDogs = chosenDogs;
    }
}
