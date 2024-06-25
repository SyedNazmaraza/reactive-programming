package com.example.reactive_programming.controller;


import com.example.reactive_programming.domain.CarDto;
import com.example.reactive_programming.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    @Autowired
    private final CarService carService;

    @GetMapping
    Flux<CarDto> getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping
    public Flux<CarDto> getCar() {
        return carService.getCarsFromThirdPartyApi();
    }

    @GetMapping("/{carId}")
    Mono<CarDto> getCarById(@PathVariable Integer carId) {
        return carService.getCarById(carId);
    }

    @PostMapping
    Mono<CarDto> createCar(@RequestBody CarDto carDto) {
        return carService.createCar(carDto);
    }

    @PutMapping("/{carId}")
    Mono<CarDto> updateCar(@PathVariable Integer carId ,@RequestBody CarDto carDto) {
        return carService.updateCar(carId,carDto);
    }

    @DeleteMapping("/{carId}")
    Mono<Void> deleteCar(@PathVariable Integer carId) {
        return carService.deleteCar(carId);
    }

}
