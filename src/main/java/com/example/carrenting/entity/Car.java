package com.example.carrenting.entity;


import org.hibernate.boot.model.relational.Database;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String bodyType;
    private String vintage;
    private String color;
    private Double mileage;
    private Status status;
    private BigDecimal amount; //per day

    public Car(Long id, String brand, String model, String bodyType, String vintage, String color, Double mileage, Status status, BigDecimal amount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.vintage = vintage;
        this.color = color;
        this.mileage = mileage;
        this.status = status;
        this.amount = amount;
    }

    public Car() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", vintage='" + vintage + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", status=" + status +
                ", amount=" + amount +
                '}';
    }
}
