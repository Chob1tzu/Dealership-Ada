package Dealership.Interface;

import Dealership.Class.Dealership;

import java.util.Date;

public interface RentService {
    void rentVehicle(Dealership dealership, RentService rentService, String vehicleId, String clientId, Date rentDate);

    double returnVehicle(Dealership dealership, RentService rentService, String vehicleId, String clientId, Date returnDate);

    double rentPrice(Dealership dealership, RentService rentService, String vehicleId, String clientId, Date returnDate);
    double calculateRentTime(Date returnDate, String vehicleId, Dealership dealership);
}

