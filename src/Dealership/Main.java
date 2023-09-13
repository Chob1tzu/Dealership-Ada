package Dealership;


import Dealership.Class.Dealership;
import Dealership.Class.MediumRentImp;
import Dealership.Class.SmallRentImp;
import Dealership.Class.SuvRentImp;
import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;
import Dealership.Interface.RentService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Dealership dealership = new Dealership();
        RentService suvRentService = new SuvRentImp();
        RentService smallRentService = new SmallRentImp();
        RentService mediumRentService = new MediumRentImp();

        dealership.registerVehicle("123", VehicleType.SUV,"Ford", "KA", "2010", "Black");
        dealership.registerVehicle("456", VehicleType.SMALL,"Chevrolet ", "Camaro", "2011", "White");
        dealership.registerVehicle("789", VehicleType.MEDIUM,"Volkswagen ", "Kombi", "2012", "Red");


        dealership.registerClient("111EIN","Paulo", ClientType.EIN);
        dealership.registerClient("222SSN","Rodrigo", ClientType.SSN);
        dealership.registerClient("333SSN","Bruno", ClientType.SSN);

        System.out.println();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            suvRentService.rentVehicle(dealership,"123","111EIN", rentDate, "SP");

            Date returnDate = dateFormat.parse("2023-09-10 13:30:00");
            double rentalPrice = suvRentService.returnVehicle(dealership,"123", "111EIN", returnDate, "RJ");
            System.out.println("Rental Price: $" + rentalPrice);
            System.out.println();
        } catch (Exception e) {
            System.err.println("error");
        }
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            smallRentService.rentVehicle(dealership,"456","222SSN", rentDate, "RS");

            Date returnDate = dateFormat.parse("2023-09-10 13:30:00");
            double rentalPrice = smallRentService.returnVehicle(dealership,"456", "111EIN", returnDate, "RJ");
            System.out.println("Rental Price: $" + rentalPrice);
            System.out.println();
        } catch (Exception e) {
            System.err.println("error");
        }
        try {
            Date rentDate = dateFormat.parse("2023-09-10 10:00:00");
            mediumRentService.rentVehicle(dealership,"789","333SSN", rentDate, "MG");

            Date returnDate = dateFormat.parse("2023-09-10 13:30:00");
            double rentalPrice = mediumRentService.returnVehicle(dealership,"789", "111EIN", returnDate, "RJ");
            System.out.println("Rental Price: $" + rentalPrice);
            System.out.println();
        } catch (Exception e) {
            System.err.println("error");
        }

    }
}
