package com.example.EstateAdvertBackend.services;

import com.example.EstateAdvertBackend.models.Advert;
import com.example.EstateAdvertBackend.models.User;
import com.example.EstateAdvertBackend.repo.AdvertRepository;
import com.example.EstateAdvertBackend.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertService {
    UserRepository userRepository;
    AdvertRepository advertRepository;
    public List<Advert> getAdverts() {
       String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
       User user = userRepository.findByEmail(currentPrincipalName).get();
       return  advertRepository.findByUserId(user.getId())
               .stream()
               .map(advert -> {
                   advert.setUser(null);
                   return advert;
               })
               .collect(Collectors.toList());
    }


    public Advert updateAdvert(Advert advert) {
        return advertRepository.save(advert);
    }

    public Advert addAdvert(Advert advert) {
        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(currentPrincipalName).get();
        advert.setUser(user);
        return advertRepository.save(advert);
    }

    public void deleteAdvert(Integer id){
        advertRepository.deleteById(id);
    }
}
