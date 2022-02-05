package com.samcodes.example.walkly_backend.controllers;

import com.samcodes.example.walkly_backend.models.Booking;
import com.samcodes.example.walkly_backend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(name = "owner_id", required = false) Long owner_id){
        if (owner_id != null){
            return new ResponseEntity<>(bookingRepository.findByOwnerId(owner_id), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Long id){
        Booking toUpdate = bookingRepository.findById(id).get();
        toUpdate.setStartDate(booking.getStartDate());
        toUpdate.setEndDate(booking.getEndDate());
        toUpdate.setLengthOfWalk(booking.getLengthOfWalk());
        toUpdate.setOwner(booking.getOwner());
        toUpdate.setDogs(booking.getDogs());
        toUpdate.setWalker(booking.getWalker());
        bookingRepository.save(toUpdate);
        return new ResponseEntity<>(toUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<Long> deletedBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
