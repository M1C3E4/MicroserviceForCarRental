package com.example.microserviceforcarrental.controller;

import com.example.microserviceforcarrental.model.CarEntity;
import com.example.microserviceforcarrental.repository.CarRepository;
import com.example.microserviceforcarrental.service.CarService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CarController {
    private CarService carService;
    private CarRepository carRepository;

    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    @GetMapping("/findById/{id}")
    public Optional<CarEntity> carById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping("/add")
    public CarEntity add(@RequestBody CarEntity carEntity) {
        return carService.addCar(carEntity);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        CarEntity carEntity = new CarEntity(1L, "bmw", "x5");
        addCar(carEntity);
    }


    public CarEntity addCar(CarEntity carEntity) {
        return carRepository.save(carEntity);
    }

}

