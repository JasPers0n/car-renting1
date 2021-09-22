package com.example.carrenting.controller;

import com.example.carrenting.entity.Booking;
import com.example.carrenting.entity.Employee;
import com.example.carrenting.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/viewBookingForm")
    public String viewBookingForm(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "/booking/booking-add-form";
    }

    @PostMapping("/saveBooking")
    public String saveEmployee(@ModelAttribute("employee") Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/employee/employee-list";
    }

}
