package Dealership.Class;

import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CarDealership {
    private List<Vehicle> vehicles;
    private List<Client> clients;

    public CarDealership() {
        vehicles = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void registerVehicle(String plateNumber, VehicleType type) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                System.out.println("Vehicle with this plate number already exists.");
                return;
            }
        }

        Vehicle newVehicle = new Vehicle(plateNumber, type);
        vehicles.add(newVehicle);
        System.out.println("Vehicle registered successfully.");
    }

    public void modifyVehicle(String plateNumber, VehicleType newType) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                vehicle = new Vehicle(plateNumber, newType);
                System.out.println("Vehicle modified successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public Vehicle searchVehicle(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }

    public void registerClient(String id, ClientType type) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                System.out.println("Client with this ID already exists.");
                return;
            }
        }

        Client newClient = new Client(id, type);
        clients.add(newClient);
        System.out.println("Client registered successfully.");
    }

    public void modifyClient(String id, ClientType newType) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                client = new Client(id, newType);
                System.out.println("Client modified successfully.");
                return;
            }
        }
        System.out.println("Client not found.");
    }

    public boolean rentVehicle(String plateNumber, String clientId, Date rentDate) {
        Vehicle vehicle = searchVehicle(plateNumber);
        if (vehicle != null && !vehicle.isRented()) {
            Client client = findClientById(clientId);
            if (client != null) {
                vehicle.rentVehicle(rentDate);
                System.out.println("Vehicle rented successfully.");
                return true;
            } else {
                System.out.println("Client not found.");
            }
        } else if (vehicle != null && vehicle.isRented()) {
            System.out.println("Vehicle is already rented.");
        } else {
            System.out.println("Vehicle not found.");
        }
        return false;
    }

    public double returnVehicle(String plateNumber, Date returnDate) {
        Vehicle vehicle = searchVehicle(plateNumber);
        if (vehicle != null && vehicle.isRented()) {
            double rentalPrice = vehicle.returnVehicle(returnDate);
            System.out.println("Vehicle returned successfully.");
            return rentalPrice;
        } else if (vehicle != null && !vehicle.isRented()) {
            System.out.println("Vehicle is not currently rented.");
        } else {
            System.out.println("Vehicle not found.");
        }
        return 0.0; // Vehicle not found or not rented
    }

    private Client findClientById(String clientId) {
        for (Client client : clients) {
            if (client.getId().equals(clientId)) {
                return client;
            }
        }
        return null; // Client not found
    }
}