package com.example.carrenting.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Brand musi posiadać niebiały znak")
    @Size(min = 3, message = "Brand musi posiadac minimum {min} znak")
    private String brand;
    @NotBlank(message = "model musi posiadać niebiały znak")
    @Size(min = 1, message = "model musi posiadac minimum {min} znak")
    private String model;
    @NotBlank(message = "Body type musi posiadać niebiały znak")
    @Size(min = 1, message = "Body type musi posiadac minimum {min} znak")
    private String bodyType;
    @NotBlank(message = "vintage musi posiadać niebiały znak")
    @Size(min = 1, message = "vintage musi posiadac minimum {min} znak")
    private String vintage;
    @NotBlank(message = "color musi posiadać niebiały znak")
    @Size(min = 1, message = "color musi posiadac minimum {min} znak")
    private String color;
    @NotNull

    private Double mileage;
    @NotNull

    private Status status;


    @NotNull
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
