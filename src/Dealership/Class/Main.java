package Dealership.Class;


import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CarDealership dealership = new CarDealership();

        dealership.registerVehicle("ABC123", VehicleType.SMALL);
        dealership.registerVehicle("XYZ456", VehicleType.MEDIUM);

        dealership.registerClient("Roberto", "123.456.789-41", ClientType.SSN);
        dealership.registerClient("Bradesco Empresa", "60.746.948/0001-12", ClientType.EIN);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            dealership.rentVehicle("ABC123", "123EIN", rentDate);

            // Return the vehicle
            Date returnDate = dateFormat.parse("2023-09-11 10:00:00");
            double rentalPrice = dealership.returnVehicle("ABC123", returnDate);
            System.out.println("Rental Price: $" + rentalPrice);
        } catch (Exception e) {
            System.out.println("error while trying to return a vehicle. ");
        }

    }
}
