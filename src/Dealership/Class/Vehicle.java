package Dealership.Class;

import Dealership.Enum.VehicleType;

import java.util.Date;

public class Vehicle {
    protected String plateNumber;
    protected VehicleType type;
    protected String brand;
    protected String model;
    protected String color;
    protected String year;
    protected boolean isRented;
    protected Date lastRentedDate;

    public Vehicle(String plateNumber, VehicleType type, String brand, String model, String year, String color) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRented = false;
        this.lastRentedDate = null;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public void setRented() {
        this.isRented = false;
    }

    public void setLastRentedDate() {
        this.lastRentedDate = null;
    }

    public boolean isRented() {
        return isRented;
    }

    public void vehicleRent(Date rentDate) {
        if (!isRented) {
            this.isRented = true;
            this.lastRentedDate = rentDate;
        }
    }

}