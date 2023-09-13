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
                System.out.println("Vehicle with this plate number already exists.");
                return;
            }
        }

        Vehicle newVehicle = new Vehicle(plateNumber, type, brand, model, year, color);
        vehicles.add(newVehicle);
        System.out.println("Vehicle registered successfully.");
    }
    // ARRUMAR O MODIFICADOR DE VEICULO PARA USAR O MÉTOODO DE BUSCA MODIFICAR COISAS ESPECÍFICAS
    public Vehicle searchVehicleByPlate(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return vehicle;
            }
        }
        System.out.println("Client not found.");
        return null;
    }
    public void modifyVehicle(String plateNumber, String newPlateNumber, VehicleType type, String brand, String model, String year) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                vehicle.setType(type);
                vehicle.setBrand(brand);
                vehicle.setModel(model);
                vehicle.setYear(year);
                vehicle.setPlateNumber(newPlateNumber);

                System.out.println("Vehicle modified successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }


    public void registerClient(String id, String name, ClientType type) {
        for (Client client : clients) {
            if (client.getClientId().equals(id)) {
                System.out.println("Client with this ID already exists.");
                return;
            }
        }

        Client newClient = new Client(id, name, type);
        clients.add(newClient);
        System.out.println("Client registered successfully.");
    }

    public Client searchClientById(String clientId) {
        for (Client client : clients) {
            if (client.getClientId().equals(clientId)) {
                return client;
            }
        }
        System.out.println("Client not found.");
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
    // ARRUMAR O MODIFICADOR DE CLIENTE PARA USAR O método findClient
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
