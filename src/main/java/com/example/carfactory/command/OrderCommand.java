package com.example.carfactory.command;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class OrderCommand implements Serializable {

    @NotEmpty(message = "brand of the vehicle cannot be empty")
    private String brand;

    @NotEmpty(message = "model of the vehicle cannot be empty")
    private String model;

    @NotEmpty(message = "color of the vehicle cannot be empty")
    private String color;

    @NotEmpty(message = "client's email address cannot be empty")
    private String clientEmail;

}
