package com.example.EstateAdvertBackend.repo;

import com.example.EstateAdvertBackend.models.Advert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdvertRepository extends JpaRepository <Advert, Integer>{


    List<Advert> findByUserId(Integer userId);

}

