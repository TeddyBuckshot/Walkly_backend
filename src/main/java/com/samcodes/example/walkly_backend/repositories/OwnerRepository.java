package com.samcodes.example.walkly_backend.repositories;

import com.samcodes.example.walkly_backend.models.person.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByBookingsId(long id);
    List<Owner> findByDogsId(long id);
}
