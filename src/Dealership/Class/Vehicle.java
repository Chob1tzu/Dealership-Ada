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
    protected String rentLocation;
    protected String returnLocation;

    public Vehicle(String plateNumber, VehicleType type, String brand, String model, String year, String color) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRented = false;
        this.lastRentedDate = null;
        this.rentLocation = null;
        this.returnLocation = null;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public VehicleType getType() {
        return type;
    }

    void setType(VehicleType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    void setBrand(String brand) { this.brand = brand; }

    public String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    void setYear(String year) {
        this.year = year;
    }

    void setRented() {
        this.isRented = false;
    }

    void setLastRentedDate() {
        this.lastRentedDate = null;
    }

    boolean isRented() {
        return isRented;
    }

    void vehicleRent(Date rentDate, String rentLocation) {
        if (!isRented) {
            this.isRented = true;
            this.rentLocation = rentLocation;
            this.lastRentedDate = rentDate;
        }
    }
    void vehicleReturn(Date rentDate, String returnLocation) {
        if (isRented) {
            this.isRented = false;
            this.returnLocation = returnLocation;
            this.lastRentedDate = rentDate;
        }
    }

}