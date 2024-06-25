package com.example.reactive_programming.domain;

import com.example.reactive_programming.entity.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Integer id;
    private String brand;
    private Integer kilowatt;
    public CarDto(CarEntity carEntity) {
        this.id = carEntity.getId();
        this.brand = carEntity.getBrand();
        this.kilowatt = carEntity.getKilowatt();
    }
}
