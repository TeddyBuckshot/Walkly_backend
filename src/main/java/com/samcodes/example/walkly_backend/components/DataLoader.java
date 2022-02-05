package com.samcodes.example.walkly_backend.components;

import com.samcodes.example.walkly_backend.models.Booking;
import com.samcodes.example.walkly_backend.models.animal.Dog;
import com.samcodes.example.walkly_backend.models.animal.dogSize;
import com.samcodes.example.walkly_backend.models.person.Owner;
import com.samcodes.example.walkly_backend.models.person.Walker;
import com.samcodes.example.walkly_backend.repositories.BookingRepository;
import com.samcodes.example.walkly_backend.repositories.DogRepository;
import com.samcodes.example.walkly_backend.repositories.OwnerRepository;
import com.samcodes.example.walkly_backend.repositories.WalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DogRepository dogRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    WalkerRepository walkerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Owner owner1 = new Owner("Sam", "I work shifts and need some help",4);
        Owner owner2 = new Owner("James", "I'm a doctor with 2 pups!",3);
        Owner owner3 = new Owner("Lauren", "I have 3 dogs and 3 children",5);
        Owner owner4 = new Owner("Linzi", "Really need some help, usually last min",2);

        Dog dog1 = new Dog("chump","labrador", dogSize.MEDIUM,owner1);
        Dog dog2 = new Dog("jingles","husky", dogSize.LARGE,owner2);
        Dog dog3 = new Dog("sausage","terrier", dogSize.SMALL,owner2);
        Dog dog4 = new Dog("bumble","spaniel", dogSize.SMALL,owner3);
        Dog dog5 = new Dog("chops","retriever", dogSize.MEDIUM,owner3);
        Dog dog6 = new Dog("arnold","shiba inu", dogSize.SMALL,owner3);
        Dog dog7 = new Dog("bingo","great dane", dogSize.LARGE, owner4);

        Walker walker1 = new Walker("Terry","terry walks dogs", 12, "dog lover", 5);
        Walker walker2 = new Walker("Louise","Louise loves dogs", 15, "dog lover 2", 4);
        Walker walker3 = new Walker("Arthur","outWithArthur", 16, "dog lover 3", 3);
        Walker walker4 = new Walker("Jennifer","Jen the dog lady", 11, "dog lover 4", 2);

        Booking booking1 = new Booking("01/01/2022","01/03/2022",60,owner1,walker1);
        Booking booking2 = new Booking("02/02/2022","02/04/2022",60,owner2,walker1);
        Booking booking3 = new Booking("03/01/2022","03/03/2022",60,owner1,walker2);
        Booking booking4 = new Booking("04/01/2022","04/03/2022",60,owner2,walker2);

        Booking booking5 = new Booking("05/01/2022","05/03/2022",60,owner3,walker3);
        Booking booking6 = new Booking("06/01/2022","06/03/2022",60,owner3,walker4);
        Booking booking7 = new Booking("07/01/2022","07/03/2022",60,owner4,walker3);
        Booking booking8 = new Booking("08/01/2022","08/03/2022",60,owner4,walker4);

    }
}
