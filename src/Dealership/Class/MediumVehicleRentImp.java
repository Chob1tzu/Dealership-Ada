package Dealership.Class;

import Dealership.Interface.RentService;

import java.util.Date;

public class MediumVehicleRentImp implements RentService {
    private static final double MEDIUM_RATE = 150.0;
    private static final double SSN_DISCOUNT = 0.05;
    private static final double EIN_DISCOUNT = 0.10;

    public boolean rentVehicle(Dealership dealership, RentService rentService, String vehicleId, String clientId, Date rentDate) {
        Vehicle vehicle = dealership.searchVehicleById(vehicleId);
        if (vehicle != null && !vehicle.isRented()) {
            Client client = dealership.searchClientById(clientId);
            if (client != null) {
                vehicle.rentVehicle(rentDate);
                System.out.println("Medium Vehicle rented successfully.");
                return true;
            } else {
                System.out.println("Client not found.");
            }
        } else if (vehicle != null && vehicle.isRented()) {
            System.out.println("Vehicle is already rented.");
        } else {
            System.out.println("Vehicle not found.");
        }
        return false;
    }
    @Override
    public double returnVehicle(Dealership dealership, RentService rentService, String vehicleId, String clientId, Date returnDate) {
        Vehicle vehicle = dealership.searchVehicleById(vehicleId);
        if (vehicle != null && vehicle.isRented()) {
            double rentalPrice = rentService.rentPrice(dealership, rentService, vehicleId, clientId, returnDate);
            System.out.println("Vehicle returned successfully.");
            return rentalPrice;
        } else if (vehicle != null) {
            System.out.println("Vehicle is not currently rented.");
        } else {
            System.out.println("Vehicle not found.");
        }
        return 0;
    }
    @Override
    public double rentPrice(Dealership dealership, RentService rentService, String vehicleId, String clientId, Date returnDate) {
        Client client = dealership.searchClientById(clientId);
        Vehicle vehicle = dealership.searchVehicleById(vehicleId);
        if (vehicle.isRented) {
            // Calculate the rental duration in days
            long rentalDuration = (returnDate.getTime() - vehicle.lastRentedDate.getTime()) / (24 * 60 * 60 * 1000);

            double rentalPrice = MEDIUM_RATE * rentalDuration;

            switch (client.getType()) {
                case SSN:
                    if (rentalDuration >= 5) {
                        rentalPrice *= 1 - SSN_DISCOUNT;
                    }
                    break;
                case EIN:
                    if (rentalDuration >= 3) {
                        rentalPrice *= 1 - EIN_DISCOUNT;
                    }
                    break;
            }

            vehicle.setRented();
            vehicle.setLastRentedDate();
            return rentalPrice;
        }
        return 0;
    }
}
