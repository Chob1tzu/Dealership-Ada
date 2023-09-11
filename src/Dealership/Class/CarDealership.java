package Dealership.Class;

import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;
import Dealership.Interface.RentalService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CarDealership {
    private List<Vehicle> vehicles;
    private List<Client> clients;
    private RentalService rentalService;

    public CarDealership() {
        vehicles = new ArrayList<>();
        clients = new ArrayList<>();
        rentalService = new RentingServiceImpl();
    }

    public void registerVehicle(String plateNumber, VehicleType type) {
        // Implement vehicle registration
    }

    public void modifyVehicle(String plateNumber, VehicleType newType) {
        // Implement vehicle modification
    }

    public void searchVehicle(String plateNumber) {
        // Implement vehicle search
    }

    public void registerClient(String identifier, ClientType type) {
        // Implement client registration
    }

    public void modifyClient(String identifier, ClientType newType) {
        // Implement client modification
    }

    // Other methods for searching clients

    // Example methods for renting and returning vehicles
    public void rentVehicle(Client client, Vehicle vehicle, Date rentDate, int rentalDays) {
        rentalService.rentVehicle(client, vehicle, rentDate, rentalDays);
    }

    public void returnVehicle(Client client, Vehicle vehicle, Date returnDate) {
        rentalService.returnVehicle(client, vehicle, returnDate);
    }

    public Map<Object, Object> getClients() {
        //CREATE CODE
        return null;
    }

    public Map<Object, Object> getVehicles() {
        //CREATE CODE
        return null;
    }

    public void rentVehicle(Object o, Object o1, Date rentDate, int rentalDays) {
    }
}
