package com.samcodes.example.walkly_backend.controllers.person;

import com.samcodes.example.walkly_backend.models.person.Owner;
import com.samcodes.example.walkly_backend.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getAllOwners(@RequestParam(name = "booking_id", required = false) Long booking_id){
        if (booking_id != null){
            return new ResponseEntity<>(ownerRepository.findByBookingsId(booking_id), HttpStatus.OK);
        }
        return new ResponseEntity<>(ownerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id){
        return new ResponseEntity(ownerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/owners")
    public ResponseEntity<Owner> postOwner(@RequestBody Owner owner){
        ownerRepository.save(owner);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PutMapping(value = "/owners/{id}")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner, @PathVariable Long id){
        Owner toUpdate = ownerRepository.findById(id).get();
        toUpdate.setName(owner.getName());
        toUpdate.setBio(owner.getBio());
        toUpdate.setRating(owner.getRating());
        toUpdate.setBookings(owner.getBookings());
        toUpdate.setDogs(owner.getDogs());
        ownerRepository.save(toUpdate);
        return new ResponseEntity<>(toUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/owners/{id}")
    public ResponseEntity<Long> deletedOwner(@PathVariable Long id){
        ownerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}