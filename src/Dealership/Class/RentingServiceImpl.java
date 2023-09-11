package Dealership.Class;

import Dealership.Interface.RentalService;

import java.util.Date;

public class RentingServiceImpl implements RentalService {
    public void rentVehicle(Client client, Vehicle vehicle, Date rentDate, int rentalDays) {
        // Implement rent logic with discounts for EIN and SSN clients
    }

    public void returnVehicle(Client client, Vehicle vehicle, Date returnDate) {
        // Implement return logic and calculate the final price
    }
}
