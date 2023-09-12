package Dealership;


import Dealership.Class.Dealership;
import Dealership.Class.SuvVehicleRentImp;
import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;
import Dealership.Interface.RentService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Dealership dealership = new Dealership();
        RentService rentService = new SuvVehicleRentImp();
        dealership.registerVehicle("123", VehicleType.SMALL,"Ford", "KA", "2010", "ABC123");


        dealership.registerClient("Paulo","123EIN", ClientType.EIN);
        dealership.registerClient("Rodrigo","456SSN", ClientType.SSN);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            rentService.rentVehicle(dealership,rentService,"123","123EIN", rentDate);

            // Return the vehicle
            Date returnDate = dateFormat.parse("2023-09-11 11:00:00");
            double rentalPrice = rentService.returnVehicle(dealership, rentService, "123", "123EIN", returnDate);
            System.out.println("Rental Price: $" + rentalPrice);
        } catch (Exception e) {
            System.out.println("erro");
        }

    }
}
