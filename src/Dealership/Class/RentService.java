package Dealership.Class;

import Dealership.Enum.ClientType;
import Dealership.Interface.RentalService;

import java.util.Date;

public class RentService implements RentalService {
    private static final double SMALL_RATE = 100.0;
    private static final double MEDIUM_RATE = 150.0;
    private static final double SUV_RATE = 200.0;
    private static final double SSN_DISCOUNT = 0.05;
    private static final double EIN_DISCOUNT = 0.10;


    public double rentVehicle(Vehicle vehicle, Client client, Date startDate, int numberOfDays) {
        if (vehicle.isRented()) {
            System.out.println("Vehicle is already rented.");
            return -1;
        }

        double rate = switch (vehicle.getType()) {
            case SMALL -> SMALL_RATE;
            case MEDIUM -> MEDIUM_RATE;
            case SUV -> SUV_RATE;
            default -> 0;
        };

        if (client.getType() == ClientType.SSN && numberOfDays >= 5) rate *= (1 - SSN_DISCOUNT);
        else if (client.getType() == ClientType.EIN && numberOfDays >= 3) rate *= (1 - EIN_DISCOUNT);

        double rentalPrice = rate * numberOfDays;
        vehicle.rent();
        return rentalPrice;
    }

    public void returnVehicle(Vehicle vehicle, Date returnDate) {
        if (!vehicle.isRented()) {
            System.out.println("Vehicle is not rented.");
        }

        vehicle.returnVehicle();
        System.out.println("Vehicle returned successfully.");
    }

    @Override
    public void rentVehicle(Client client, Vehicle vehicle, Date rentDate, int rentalDays) {

    }

    @Override
    public void returnVehicle(Client client, Vehicle vehicle, Date returnDate) {

    }
}

