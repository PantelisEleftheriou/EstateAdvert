package com.example.EstateAdvertBackend;

import com.example.EstateAdvertBackend.models.Advert;
import com.example.EstateAdvertBackend.models.Role;
import com.example.EstateAdvertBackend.models.User;
import com.example.EstateAdvertBackend.repo.AdvertRepository;
import com.example.EstateAdvertBackend.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class RunAfterStartup {

    UserRepository userRepository;
    AdvertRepository advertRepository;

    PasswordEncoder passwordEncoder;
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartUp() {
        User user1 = userRepository.save(new User("pantelis","elef","pa@gmail.com",passwordEncoder.encode("1234"), Role.USER));
        User user2 = userRepository.save(new User("pantelis","elef","pan@gmail.com",passwordEncoder.encode("1234"), Role.USER));
        User user3 = userRepository.save(new User("pantelis","elef","pant@gmail.com",passwordEncoder.encode("1234"), Role.USER));
        User user4 = userRepository.save(new User("pantelis","elef","pante@gmail.com",passwordEncoder.encode("1234"), Role.USER));

        advertRepository.saveAll(new ArrayList<Advert>(){{
            add(new Advert(1000,"Ath","rent",60,user1));
            add(new Advert(2000,"Larisa","rent",150,user2));
            add(new Advert(4000,"Volos","buy",200,user3));
            add(new Advert(800,"Patra","rent",60,user4));
            add(new Advert(700,"Thess","buy",90,user2));
            add(new Advert(900,"Xios","rent",80,user1));

        }});
    }
}
