package com.example.carrenting.controller;

import com.example.carrenting.entity.Booking;
import com.example.carrenting.entity.Employee;
import com.example.carrenting.service.BookingService;
import com.example.carrenting.service.CarService;
import com.example.carrenting.service.ClientService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Secured({"ROLE_MANAGER", "ROLE_CLIENT", "ROLE_EMPLOYEE"})
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;
    private ClientService clientService;
    private CarService carService;

    public BookingController(BookingService bookingService, ClientService clientService, CarService carService) {
        this.bookingService = bookingService;
        this.clientService = clientService;
        this.carService = carService;
    }

    @GetMapping("/viewBookingForm")
    public String viewBookingForm(Model model, @ModelAttribute("booking") Booking booking) {
        model.addAttribute("client", clientService.getAll());
        model.addAttribute("car", carService.getAll());
        return "/booking/booking-add-form";
    }

    @PostMapping("/saveBooking")
    public String saveEmployee(@ModelAttribute("employee") Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/booking/booking-list";
    }

    @GetMapping("booking-list")
    public String showBookingList(Model model){
        model.addAttribute("list", bookingService.getAll());
        return "/booking/booking-list";
    }

}
