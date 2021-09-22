package com.example.carrenting.service;

import com.example.carrenting.entity.Booking;
import com.example.carrenting.entity.Employee;
import com.example.carrenting.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void saveBooking(Booking booking) {
        this.bookingRepository.save(booking);
    }

    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }
}
