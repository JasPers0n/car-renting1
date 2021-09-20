package com.example.carrenting.controller;

import com.example.carrenting.entity.Car;
import com.example.carrenting.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/add") // http://localhost:8080/car/add
    public String example3Form(@ModelAttribute("car") Car car) {
        return "car/form";
    }

    @PostMapping("/add") // http://localhost:8080/car/add
    public String example3Result(@ModelAttribute("car") Car car) {
        carRepository.save(car);
        return "car/result";
    }
    @GetMapping("/list") // http://localhost:8080/car/list
    public String example4(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "car/list";
    }
}
