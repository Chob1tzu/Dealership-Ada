package Dealership.Class;


import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CarDealership dealership = new CarDealership();
        RentService rentService = new RentService();

        dealership.registerVehicle("ABC123", VehicleType.SMALL);
        dealership.registerVehicle("XYZ456", VehicleType.MEDIUM);

        dealership.registerClient("Paulo","123EIN", ClientType.EIN);
        dealership.registerClient("Rodrigo","456SSN", ClientType.SSN);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            rentService.rentVehicle(dealership,"ABC123", "123EIN", rentDate);

            // Return the vehicle
            Date returnDate = dateFormat.parse("2023-09-14 10:00:00");
            double rentalPrice = rentService.returnVehicle(dealership,rentService, "ABC123", returnDate);
            System.out.println("Rental Price: $" + rentalPrice);
        } catch (Exception e) {
            System.out.println("error while trying to return a vehicle. ");
        }

    }
}
