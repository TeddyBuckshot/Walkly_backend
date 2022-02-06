package com.samcodes.example.walkly_backend;

import com.samcodes.example.walkly_backend.models.Booking;
import com.samcodes.example.walkly_backend.models.animal.Dog;
import com.samcodes.example.walkly_backend.models.animal.dogSize;
import com.samcodes.example.walkly_backend.models.person.Owner;
import com.samcodes.example.walkly_backend.models.person.Walker;
import com.samcodes.example.walkly_backend.repositories.BookingRepository;
import com.samcodes.example.walkly_backend.repositories.DogRepository;
import com.samcodes.example.walkly_backend.repositories.OwnerRepository;
import com.samcodes.example.walkly_backend.repositories.WalkerRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalklyBackendApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	DogRepository dogRepository;

	@Autowired
	OwnerRepository ownerRepository;

	@Autowired
	WalkerRepository walkerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddDogToBooking(){

	}

}
