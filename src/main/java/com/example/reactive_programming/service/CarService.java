package com.example.reactive_programming.service;

import com.example.reactive_programming.domain.CarDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {
    Mono<CarDto> createCar(CarDto carDto);
    Mono<CarDto> getCarById(Integer id);
    Mono<CarDto> updateCar(Integer id, CarDto carDto);
    Mono<Void> deleteCar(Integer id);
    Flux<CarDto> getAllCars();
    Flux<CarDto> getCarsFromThirdPartyApi();
}
