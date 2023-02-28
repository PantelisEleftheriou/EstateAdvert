package com.example.EstateAdvertBackend.controllers;

import com.example.EstateAdvertBackend.models.Advert;
import com.example.EstateAdvertBackend.services.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/advert")
@AllArgsConstructor
public class AdvertController {

    AdvertService advertService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Advert>> getAdverts() {
        return ResponseEntity.ok(advertService.getAdverts());
    }

    @PostMapping("/add")
    public ResponseEntity<Advert> addAdvert(@RequestBody Advert advert) {
        Advert newAdvert = advertService.addAdvert(advert);
        return new ResponseEntity<>(newAdvert, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Advert> updateAdvert(@RequestBody Advert advert) {
        Advert updateAdvert = advertService.updateAdvert(advert);
        return new ResponseEntity<>(updateAdvert, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdvert(@PathVariable("id") Integer id) {
        advertService.deleteAdvert(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
