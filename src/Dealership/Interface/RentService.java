package Dealership.Interface;

import Dealership.Class.Dealership;

import java.util.Date;

public interface RentService {
    void rentVehicle(Dealership dealership, String plateNumber, String clientId, Date rentDate);
    double returnVehicle(Dealership dealership, String plateNumber, String clientId, Date returnDate);
    double rentPrice(Dealership dealership, String plateNumber, String clientId, Date returnDate);
    double calculateRentTime(Dealership dealership, String plateNumber,Date returnDate);
}

