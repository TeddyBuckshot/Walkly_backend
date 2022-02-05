package com.samcodes.example.walkly_backend.repositories;

import com.samcodes.example.walkly_backend.models.person.Walker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long> {
    List<Walker> findByBookingsId(long id);
    List<Walker> findByRating(int rating);
    List<Walker> findAllByBookingsChosenDogsId(long id);
    List<Walker> findByPricePerHour(double price);
}
