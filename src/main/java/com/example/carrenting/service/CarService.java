package com.example.carrenting.service;

import com.example.carrenting.entity.Car;
import com.example.carrenting.entity.Employee;
import com.example.carrenting.repository.CarRepository;
import com.example.carrenting.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void saveCar(Car car) {
        this.carRepository.save(car);
    }

    public Car getCarById(long id) {
        Optional<Car> optional = carRepository.findById(id);
        Car car = optional.get();
        return car;
    }

    public void deleteCar(long id) {
        this.carRepository.deleteById(id);
    }

}

