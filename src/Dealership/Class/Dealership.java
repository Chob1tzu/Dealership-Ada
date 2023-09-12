package Dealership.Class;

import Dealership.Enum.ClientType;
import Dealership.Enum.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Dealership {
    private List<Vehicle> vehicles;
    private List<Client> clients;

    public Dealership() {
        vehicles = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void registerVehicle(String vehicleId, VehicleType type, String brand, String model, String year, String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                System.out.println("Vehicle with this plate number already exists.");
                return;
            }
        }

        Vehicle newVehicle = new Vehicle(vehicleId, type, brand, model, year, plateNumber);
        vehicles.add(newVehicle);
        System.out.println("Vehicle registered successfully.");
    }
    public Vehicle searchVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(id)) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }
    // ARRUMAR O MODIFICADOR DE VEICULO PARA USAR O MÉTOODO DE BUSCA MODIFICAR COISAS ESPECÍFICAS
    public void modifyVehicle(String id,VehicleType type, String brand, String model, String year, String plateNumber, boolean isRented, Date lastRentedDate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                vehicle = new Vehicle(id, type, brand, model, year, plateNumber);
                System.out.println("Vehicle modified successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }


    public void registerClient(String name,String id, ClientType type) {
        for (Client client : clients) {
            if (client.getClientId().equals(id)) {
                System.out.println("Client with this ID already exists.");
                return;
            }
        }

        Client newClient = new Client(name,id, type);
        clients.add(newClient);
        System.out.println("Client registered successfully.");
    }

    public Client searchClientById(String clientId) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientId)) {
                return client;
            }
        }
        return null; // Client not found
    }
    private Client findClientByName(String clientName) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientName)) {
                return client;
            }
        }
        return null; // Client not found
    }
    // ARRUMAR O MODIFICADOR DE CLIENTE PARA USAR O método findClient
    public void modifyClient(String id, String newName, ClientType newType) {
        for (Client client : clients) {
            if (client.getClientId().equals(id)) {
                client = new Client(id, newName, newType);
                System.out.println("Client modified successfully.");
                return;
            }
        }
        System.out.println("Client not found.");
    }

}
