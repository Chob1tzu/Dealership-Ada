package Dealership;


import Dealership.Class.Dealership;
import Dealership.Class.SuvRentImp;
import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;
import Dealership.Interface.RentService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Dealership dealership = new Dealership();
        RentService rentService = new SuvRentImp();

        dealership.registerVehicle("123", VehicleType.SUV,"Ford", "KA", "2010", "ABC123");


        dealership.registerClient("111EIN","Paulo", ClientType.EIN);
        dealership.registerClient("222SSN","Rodrigo", ClientType.SSN);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            rentService.rentVehicle(dealership,"123","111EIN", rentDate, "SP");

            // Return the vehicle
            Date returnDate = dateFormat.parse("2023-09-14 11:30:00");
            double rentalPrice = rentService.returnVehicle(dealership,"123", "111EIN", returnDate, "RJ");
            System.out.println("Rental Price: $" + rentalPrice);
        } catch (Exception e) {
            System.out.println("error");
        }

    }
}
