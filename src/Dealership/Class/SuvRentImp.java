package Dealership.Class;

import Dealership.Interface.RentService;

import java.util.Date;

public class SuvRentImp implements RentService {
    private static final double SUV_RATE = 200.0;
    private static final double SSN_DISCOUNT = 0.05;
    private static final double EIN_DISCOUNT = 0.10;

    @Override
    public void rentVehicle(Dealership dealership, String plateNumber, String clientId, Date rentDate, String rentLocation) {
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);
        Client client = dealership.searchClientById(clientId);

        if (vehicle == null) {
            System.out.printf("Vehicle with plate %s was not found.\n", plateNumber);
        } else if (client == null) {
            System.out.printf("Client with id %s was not found.\n", clientId);
        } else if (vehicle.isRented()) {
            System.out.printf("Vehicle with plate %s is already rented.\n", plateNumber);
        } else {
            vehicle.vehicleRent(rentDate, rentLocation);
            System.out.printf("SUV Vehicle with plate %s rented successfully at %s.\n", plateNumber, rentLocation);
        }
    }
    @Override
    public double returnVehicle(Dealership dealership, String plateNumber, String clientId, Date returnDate, String returnLocation) {
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);

        if (vehicle == null) {
            System.out.printf("Vehicle with plate %s was not found.\n", plateNumber);
            return 0;
        } else if (!vehicle.isRented) {
            System.out.printf("Vehicle with plate %s is not currently rented.\n", plateNumber);
            return 0;
        } else {
            double rentalPrice = rentPrice(dealership, plateNumber, clientId, returnDate);
            vehicle.vehicleReturn(returnDate, returnLocation);
            System.out.printf("Vehicle with plate %s returned successfully at %s. \n", plateNumber, returnLocation);
            return rentalPrice;
        }
    }
    @Override
    public double rentPrice(Dealership dealership, String plateNumber, String clientId, Date returnDate) {
        Client client = dealership.searchClientById(clientId);
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);

        if (vehicle.isRented) {
            double rentalDuration = calculateRentTime(dealership, plateNumber, returnDate);
            double rentalPrice = SUV_RATE * rentalDuration;

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
    public double calculateRentTime(Dealership dealership, String plateNumber, Date returnDate) {
        Vehicle vehicle = dealership.searchVehicleByPlate(plateNumber);

        long dateDifferenceInMilliseconds = returnDate.getTime() - vehicle.lastRentedDate.getTime();
        float millisecondsInADay = 24 * 60 * 60 * 1000;

        int rentalDays =  (int) Math.floor(dateDifferenceInMilliseconds / (millisecondsInADay));
        int rentalHours = (int) ((Math.floor(dateDifferenceInMilliseconds / ((millisecondsInADay / 24)) - (24 * rentalDays))));

        System.out.printf("Vehicle rented for: %d day(s) and %d hour(s). \n", rentalDays, rentalHours);

        return Math.ceil(dateDifferenceInMilliseconds / (millisecondsInADay));
    }
}
