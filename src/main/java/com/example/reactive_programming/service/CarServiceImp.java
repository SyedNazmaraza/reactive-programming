package com.example.reactive_programming.service;

import com.example.reactive_programming.domain.CarDto;
import com.example.reactive_programming.entity.CarEntity;
import com.example.reactive_programming.exception.CarServiceException;
import com.example.reactive_programming.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {
    private final WebClient webClient;
    private final CarRepository carRepository;

    @Override
    public Mono<CarDto> createCar(CarDto carDto) {
        return carRepository.save(
                CarEntity.builder()
                        .brand(carDto.getBrand())
                        .kilowatt(carDto.getKilowatt())
                        .build()
        ).map(CarDto::new).log();
    }

    @Override
    public Mono<CarDto> getCarById(Integer id) {
        return carRepository.findById(id)
                .map(CarDto::new)
                .log();
    }

    @Override
    public Mono<CarDto> updateCar(Integer id, CarDto carDto) {
        return carRepository.save(
                CarEntity.builder()
                        .id(carDto.getId())
                        .brand(carDto.getBrand())
                        .kilowatt(carDto.getKilowatt())
                        .build()
        ).map(CarDto::new).log();
    }

    @Override
    public Mono<Void> deleteCar(Integer id) {
        return carRepository.deleteById(id)
                .log();
    }

    @Override
    public Flux<CarDto> getAllCars() {
        return carRepository.findAll().map(CarDto::new).log();
    }

    @Override
    public Flux<CarDto> getCarsFromThirdPartyApi(){
        return webClient.get()
                .uri("/car")
                .retrieve()
                .bodyToFlux(CarDto.class)
                .onErrorMap(throwable ->
                        new CarServiceException("exception occurred while fetching"))
                .log();
    }
}
