package com.example.EstateAdvertBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvertDto {
    private Integer id;
    private Integer price;
    private String location;
    private boolean availability;
    private Integer squareMeters;
}
