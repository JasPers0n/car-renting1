package com.example.carrenting.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    private String branch;
    private BigDecimal price;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Client client;

    public Booking(){
    }

    public Booking(long id, LocalDate bookingDay, LocalDate start, LocalDate end, String branch, BigDecimal price, Car car, Client client) {
        this.id = id;
        this.bookingDay = bookingDay;
        this.start = start;
        this.end = end;
        this.branch = branch;
        this.price = price;
        this.car = car;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(LocalDate bookingDay) {
        this.bookingDay = bookingDay;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate from) {
        this.start = from;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate to) {
        this.end = to;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDay='" + bookingDay + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", branch='" + branch + '\'' +
                ", price=" + price +
                ", car=" + car +
                ", client=" + client +
                '}';
    }
}
