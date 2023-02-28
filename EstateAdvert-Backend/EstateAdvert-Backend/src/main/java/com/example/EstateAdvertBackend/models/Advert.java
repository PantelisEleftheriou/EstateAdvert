package com.example.EstateAdvertBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advert")
public class Advert {
    public Advert(Integer price, String location, String availability, Integer squareMeters, User user) {
        this.price = price;
        this.location = location;
        this.availability = availability;
        this.squareMeters = squareMeters;
        this.user = user;
    }

    @Id
    @GeneratedValue
    private Integer id;

    private Integer price;
    private String location;
    private String availability;
    private Integer squareMeters;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
