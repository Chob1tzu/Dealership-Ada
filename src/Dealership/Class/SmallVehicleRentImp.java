package Dealership.Class;

import Dealership.Interface.RentService;

import java.util.Date;

public class SmallVehicleRentImp implements RentService {
    private static final double SMALL_RATE = 100.0;
    private static final double SSN_DISCOUNT = 0.05;
    private static final double EIN_DISCOUNT = 0.10;

    public void rentVehicle(Dealership dealership, RentService rentService, String plateNumber, String clientId, Date rentDate) {
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);
        Client client = dealership.searchClientById(clientId);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
        } else if (client == null) {
            System.out.println("Client not found.");
        } else if (vehicle.isRented()) {
            System.out.println("Vehicle is already rented.");
        } else {
            vehicle.vehicleRent(rentDate);
            System.out.println("Small Vehicle rented successfully.");
        }
    }
    @Override
    public double returnVehicle(Dealership dealership, RentService rentService, String plateNumber, String clientId, Date returnDate) {
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);
        if (vehicle != null && vehicle.isRented()) {
            double rentalPrice = rentService.rentPrice(dealership, rentService, plateNumber, clientId, returnDate);
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
    public double rentPrice(Dealership dealership, RentService rentService, String plateNumber, String clientId, Date returnDate) {
        Client client = dealership.searchClientById(clientId);
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);
        if (vehicle.isRented) {
            // Calculate the rental duration in days

            int rentalDays =  (int) Math.floor(((double)(returnDate.getTime() - vehicle.lastRentedDate.getTime())) / (24 * 60 * 60 * 1000));
            int rentalHours = (int) Math.floor(((double)(returnDate.getTime() - vehicle.lastRentedDate.getTime()) / (60 * 60 * 1000)) - (24 * rentalDays));
            System.out.println("Vehicle rented for: " + rentalDays + " day(s) and " + rentalHours + " hour(s).");

            double rentalDuration =  Math.ceil((double) ((double)(returnDate.getTime() - vehicle.lastRentedDate.getTime())) / (24 * 60 * 60 * 1000));

            double rentalPrice = SMALL_RATE * rentalDuration;

            switch (client.getType()) {
                case SSN -> {
                    if (rentalDuration >= 5) {
                        rentalPrice *= 1 - SSN_DISCOUNT;
                    }
                }
                case EIN -> {
                    if (rentalDuration >= 3) {
                        rentalPrice *= 1 - EIN_DISCOUNT;
                    }
                }
            }

            vehicle.setRented();
            vehicle.setLastRentedDate();
            return rentalPrice;
        }
        return 0;
    }

    @Override
    public double calculateRentTime(Date returnDate, String plateNumber, Dealership dealership) {
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);

        int rentalDays =  (int) Math.floor(((double)(returnDate.getTime() - vehicle.lastRentedDate.getTime())) / (24 * 60 * 60 * 1000));
        int rentalHours = (int) Math.floor(((double)(returnDate.getTime() - vehicle.lastRentedDate.getTime()) / (60 * 60 * 1000)) - (24 * rentalDays));
        double rentalDuration = Math.ceil(((double)(returnDate.getTime() - vehicle.lastRentedDate.getTime())) / (24 * 60 * 60 * 1000));

        System.out.println("Vehicle rented for: " + rentalDays + " day(s) and " + rentalHours + " hour(s).");

        return rentalDuration;
    }
}