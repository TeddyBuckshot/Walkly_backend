package com.samcodes.example.walkly_backend.repositories;

import com.samcodes.example.walkly_backend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByOwnerId(long id);
    List<Booking> findByChosenDogsId(long id);
    List<Booking> findByWalkerId(long id);
    List<Booking> findAllByStartDate(String date);
}
