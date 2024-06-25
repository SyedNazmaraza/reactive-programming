package com.example.reactive_programming.repository;

import com.example.reactive_programming.entity.CarEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends R2dbcRepository<CarEntity,Integer> {
}
