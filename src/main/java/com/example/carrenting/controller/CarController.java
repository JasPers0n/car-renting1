package com.example.carrenting.controller;

import com.example.carrenting.entity.Car;
import com.example.carrenting.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car-list") // http://localhost:8080/car/car-list
    public String viewCarList(Model model) {
        List<Car> cars = carService.getAll();
        model.addAttribute("car", cars);
        return "car/car-list";
    }


    @GetMapping("/showAddCarForm")
    public String showAddCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "/car/car-add-form";
    }


    @PostMapping("/saveCar")
    public String saveCar(@Validated @ModelAttribute("car") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/car/car-add-form";
        } else {
            carService.saveCar(car);
            return "redirect:/car/car-list";
        }
    }

    @GetMapping("/showCarUpdateForm/{id}")
    public String showCarUpdateForm(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "/car/car-update-form";
    }


    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/car/car-list";
    }
}

