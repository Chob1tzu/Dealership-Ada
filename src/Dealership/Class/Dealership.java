package Dealership.Class;

import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;

import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private final List<Vehicle> vehicles;
    private final List<Client> clients;

    public Dealership() {
        vehicles = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void registerVehicle(String plateNumber, VehicleType type, String brand, String model, String year, String color) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                System.out.printf("Vehicle with plate number %s already exists.\n", plateNumber);
                return;
            }
        }

        Vehicle newVehicle = new Vehicle(plateNumber, type, brand, model,year, color);
        vehicles.add(newVehicle);
        System.out.printf("Vehicle with plate %s registered successfully.\n", plateNumber);
    }
    public Vehicle searchVehicleByPlate(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return vehicle;
            }
        }
        System.out.println("Client not found.");
        return null;
    }
    public void modifyVehicle(String plateNumber, VehicleType type, String brand, String model, String year) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                vehicle.setType(type);
                vehicle.setBrand(brand);
                vehicle.setModel(model);
                vehicle.setYear(year);

                System.out.printf("Vehicle with plate %s modified successfully.\n", plateNumber);
                return;
            }
        }
        System.out.printf("Vehicle with plate %s was not found.\n", plateNumber);
    }

    public void modifyVehicle(String plateNumber, String newPlateNumber, VehicleType type, String brand, String model, String year) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                vehicle.setType(type);
                vehicle.setBrand(brand);
                vehicle.setModel(model);
                vehicle.setYear(year);
                vehicle.setPlateNumber(newPlateNumber);

                System.out.printf("Vehicle with new plate %s modified successfully.\n", newPlateNumber);
                return;
            }
        }
        System.out.printf("Vehicle with plate %s was not found.\n", plateNumber);
    }


    public void registerClient(String clientId, String name, ClientType type) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientId)) {
                System.out.printf("Vehicle with ID %s already exists.\n", clientId);
                return;
            }
        }

        Client newClient = new Client(clientId, name, type);
        clients.add(newClient);
        System.out.printf("Client %s registered successfully\n", name);
    }

    public Client searchClientById(String clientId) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientId)) {
                return client;
            }
        }
        System.out.printf("Client with id %s was not found.\n", clientId);
        return null;
    }
    public Client searchClientByName(String clientName) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientName)) {
                return client;
            }
        }
        System.out.println("Client not found.");
        return null;
    }
    public void modifyClient(String clientId, String newName, ClientType newType) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientId)) {
                client.setClientId(clientId);
                client.setName(newName);
                client.setType(newType);
                System.out.println("Client modified successfully.");
                return;
            }
        }
        System.out.println("Client not found.");
    }

}
