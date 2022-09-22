package com.example.microserviceforcarrental.service;

import com.example.microserviceforcarrental.model.CarEntity;
import com.example.microserviceforcarrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Optional<CarEntity> getCarById(Long id){
        return carRepository.findById(id);
    }

}
