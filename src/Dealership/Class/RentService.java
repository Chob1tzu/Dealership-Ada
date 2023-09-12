package Dealership.Class;

import java.util.Date;

public class RentService {
    private static final double SMALL_RATE = 100.0;
    private static final double MEDIUM_RATE = 150.0;
    private static final double SUV_RATE = 200.0;
    private static final double SSN_DISCOUNT = 0.05;
    private static final double EIN_DISCOUNT = 0.10;

    public boolean rentVehicle(CarDealership dealership, String plateNumber, String clientId, Date rentDate) {
        Vehicle vehicle = dealership.searchVehicle(plateNumber);
        if (vehicle != null && !vehicle.isRented()) {
            Client client = dealership.findClientById(clientId);
            if (client != null) {
                vehicle.rentVehicle(rentDate);
                System.out.println("Vehicle rented successfully.");
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

    public double returnVehicle(CarDealership dealership,RentService rentService, String plateNumber, Date returnDate) {
        Vehicle vehicle = dealership.searchVehicle(plateNumber);
        if (vehicle != null && vehicle.isRented()) {
            double rentalPrice = rentService.rentPrice(dealership,rentService,plateNumber,returnDate);
            System.out.println("Vehicle returned successfully.");
            return rentalPrice;
        } else if (vehicle != null) {
            System.out.println("Vehicle is not currently rented.");
        } else {
            System.out.println("Vehicle not found.");
        }
        return 0;
    }

    /*
    public double rentPrice(CarDealership dealership, RentService rentService, String plateNumber, Date returnDate) {
        Vehicle vehicle = dealership.searchVehicle(plateNumber);
        if (vehicle.isRented) {
            // Calculate the rental duration in days
            long rentalDuration = (returnDate.getTime() - vehicle.lastRentedDate.getTime()) / (24 * 60 * 60 * 1000);

            // Calculate the rental price based on vehicle type
            double rentalPrice = 0.0;
            switch (vehicle.getType()) {
                case SMALL:
                    rentalPrice = rentalDuration * 100.0;
                    break;
                case MEDIUM:
                    rentalPrice = rentalDuration * 150.0;
                    break;
                case SUV:
                    rentalPrice = rentalDuration * 200.0;
                    break;
            }

            vehicle.setRented();
            vehicle.setLastRentedDate();
            return rentalPrice;
        }
        return 0.0; // Vehicle was not rented
    } */
}

