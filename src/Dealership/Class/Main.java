package Dealership.Class;


import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CarDealership dealership = new CarDealership();

        // Register a vehicle
        dealership.registerVehicle("ABC123", VehicleType.MEDIUM);

        // Register a client
        dealership.registerClient("Roberto", "123.456.789-41", ClientType.SSN);
        dealership.registerClient("Bradesco Empresa", "60.746.948/0001-12", ClientType.EIN);

        // Rent a vehicle
        Date rentDate = new Date(); // Use appropriate date and time
        dealership.rentVehicle(dealership.getClients().get(0), dealership.getVehicles().get(0), rentDate, 5);

        // Return the vehicle
        Date returnDate = new Date(); // Use appropriate date and time
        dealership.returnVehicle((Client) dealership.getClients().get(0), (Vehicle) dealership.getVehicles().get(0), returnDate);


    }
}
