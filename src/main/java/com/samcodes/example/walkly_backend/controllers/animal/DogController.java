package com.samcodes.example.walkly_backend.controllers.animal;

import com.samcodes.example.walkly_backend.models.animal.Dog;
import com.samcodes.example.walkly_backend.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    DogRepository dogRepository;

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(@RequestParam(name = "booking_id", required = false) Long booking_id){
        if (booking_id != null){
            return new ResponseEntity<>(dogRepository.findByBookingsId(booking_id), HttpStatus.OK);
        }
        return new ResponseEntity<>(dogRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable Long id){
        return new ResponseEntity(dogRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/dogs")
    public ResponseEntity<Dog> postDog(@RequestBody Dog dog){
        dogRepository.save(dog);
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @PutMapping(value = "/dogs/{id}")
    public ResponseEntity<Dog> updateDog(@RequestBody Dog dog, @PathVariable Long id){
        Dog toUpdate = dogRepository.findById(id).get();
        toUpdate.setName(dog.getName());
        toUpdate.setBreed(dog.getBreed());
        toUpdate.setSize(dog.getSize());
        toUpdate.setOwner(dog.getOwner());
//        toUpdate.setBookings(dog.getBookings());
        dogRepository.save(toUpdate);
        return new ResponseEntity<>(toUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/dogs/{id}")
    public ResponseEntity<Long> deleteDog(@PathVariable Long id){
        dogRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}