package Dealership.Class;


import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ErrorManager;

public class Main {
    private static ErrorManager logger;

    public static void main(String[] args) {


        CarDealership dealership = new CarDealership();

        dealership.registerVehicle("ABC123", VehicleType.SMALL);
        dealership.registerVehicle("XYZ456", VehicleType.MEDIUM);

        dealership.registerClient("123EIN", ClientType.EIN);
        dealership.registerClient("456SSN", ClientType.SSN);

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
