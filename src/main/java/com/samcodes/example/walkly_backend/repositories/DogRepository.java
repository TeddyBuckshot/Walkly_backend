package com.samcodes.example.walkly_backend.repositories;


import com.samcodes.example.walkly_backend.models.animal.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByOwnerId(long id);
    List<Dog> findByBookingsId(long id);
}
