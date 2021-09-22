package com.example.carrenting.entity;

import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bookingDay;
    private String start;
    private String end;
    private String branch;
    private int price;

    @ManyToOne
    private Car car;

    public Booking(){
    }

    public Booking(String bookingDay, String start, String to, String branch, int price) {
        this.bookingDay = bookingDay;
        this.start = start;
        this.end = to;
        this.branch = branch;
        this.price = price;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String from) {
        this.start = from;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String to) {
        this.end = to;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDay='" + bookingDay + '\'' +
                ", from='" + start + '\'' +
                ", to='" + end + '\'' +
                ", branch='" + branch + '\'' +
                ", price=" + price +
                '}';
    }
}
