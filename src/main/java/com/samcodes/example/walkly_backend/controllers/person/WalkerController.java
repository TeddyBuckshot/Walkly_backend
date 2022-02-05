package com.samcodes.example.walkly_backend.controllers.person;

import com.samcodes.example.walkly_backend.models.person.Walker;
import com.samcodes.example.walkly_backend.repositories.WalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class WalkerController {
    @Autowired
    WalkerRepository walkerRepository;

    @GetMapping("/walkers")
    public ResponseEntity<List<Walker>> getAllWalkers(@RequestParam(name = "booking_id", required = false) Long booking_id){
        if (booking_id != null){
            return new ResponseEntity<>(walkerRepository.findByBookingsId(booking_id), HttpStatus.OK);
        }
        return new ResponseEntity<>(walkerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/walkers/{id}")
    public ResponseEntity<Walker> getWalker(@PathVariable Long id){
        return new ResponseEntity(walkerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/walkers")
    public ResponseEntity<Walker> postWalker(@RequestBody Walker walker){
        walkerRepository.save(walker);
        return new ResponseEntity<>(walker, HttpStatus.OK);
    }

    @PutMapping(value = "/walkers/{id}")
    public ResponseEntity<Walker> updateWalker(@RequestBody Walker walker, @PathVariable Long id){
        Walker toUpdate = walkerRepository.findById(id).get();
        toUpdate.setName(walker.getName());
        toUpdate.setBusinessName(walker.getBusinessName());
        toUpdate.setPricePerHour(walker.getPricePerHour());
        toUpdate.setBio(walker.getBio());
        toUpdate.setRating(walker.getRating());
//        toUpdate.setBookings(walker.getBookings());
        walkerRepository.save(toUpdate);
        return new ResponseEntity<>(toUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/walkers/{id}")
    public ResponseEntity<Long> deleteWalker(@PathVariable Long id){
        walkerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}