package Dealership.Class;

import Dealership.Enum.VehicleType;

public class Vehicle {
    private String plateNumber;
    private VehicleType type;
    private boolean isRented;

    public Vehicle(String plateNumber, VehicleType type) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.isRented = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        isRented = true;
    }

    public void returnVehicle() {
        isRented = false;
    }
}