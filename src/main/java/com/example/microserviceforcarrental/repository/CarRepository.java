package com.example.microserviceforcarrental.repository;

import com.example.microserviceforcarrental.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Optional<CarEntity>findById(Long id);
}
