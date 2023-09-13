package Dealership;

import Dealership.Class.Client;
import Dealership.Class.Dealership;
import Dealership.Class.Vehicle;
import Dealership.Enum.VehicleType;
import Dealership.Enum.ClientType;
import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
    //    ao criar algo no mainFrame, ele aparece aqui
    private final Dealership dealership = new Dealership();
    private JPanel mainPanel;
    private JButton registerClient;
    private JButton searchClientById;
    private JButton searchClientByName;
    private JButton modifyVehicle;
    private JButton registerVehicleButton;
    private JButton modifyClient;
    private JButton searchVehicleByPlate;
    private JLabel dialogoBox;
    private JButton showInfoButton;

    public MainFrame() {
//      Informações sobre o mainFrame
        JFrame jFrame = new JFrame();
        setContentPane(mainPanel);
        setTitle("Dealership Ada");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        dialogoBox.setText("Hi " + System.getProperty("user.name") + ", welcome to Dealership Ada!");

        registerVehicleButton.addActionListener(e -> {
            String vehicleId = JOptionPane.showInputDialog(jFrame, "Enter the vehicle ID:");
            if (vehicleId == null) {
                return;
            }
            vehicleId = vehicleId.trim();
            if (vehicleId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The vehicle ID must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            VehicleType type = VehicleType.valueOf(JOptionPane.showInputDialog("Enter the vehicle type (SMALL, MEDIUM, SUV):"));
            String brand = JOptionPane.showInputDialog(jFrame, "Enter the vehicle brand:");
            if (brand == null) {
                return;
            }
            brand = brand.trim();
            if (brand.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The vehicle brand must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String model = JOptionPane.showInputDialog(jFrame, "Enter the vehicle model:");
            if (model == null) {
                return;
            }
            model = model.trim();
            if (model.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The vehicle model must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String year = JOptionPane.showInputDialog(jFrame, "Enter the vehicle year:");
            if (year == null) {
                return;
            }
            year = year.trim();
            if (year.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The vehicle year must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String color = JOptionPane.showInputDialog(jFrame, "Enter the vehicle color:");
            if (color == null) {
                return;
            }
            color = color.trim();
            if (color.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The vehicle color must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            dealership.registerVehicle(vehicleId, type, brand, model, year, color);
        });
        searchVehicleByPlate.addActionListener(e -> {
            String plateNumber = JOptionPane.showInputDialog("Enter the vehicle license plate number:");
            if (plateNumber == null) {
                return;
            }
            plateNumber = plateNumber.trim();
            if (plateNumber.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The license plate number must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Vehicle foundVehicle = dealership.searchVehicleByPlate(plateNumber);
            if (foundVehicle != null) {
                String message = "Vehicle details:\n" + "Plate: " + foundVehicle.getPlateNumber() + "\n" +
                        "Type: " + foundVehicle.getType() + "\n" +
                        "Brand: " + foundVehicle.getBrand() + "\n" +
                        "Model: " + foundVehicle.getModel() + "\n" +
                        "Year: " + foundVehicle.getYear() + "\n" +
                        "Color: " + foundVehicle.getColor() + "\n";

                JOptionPane.showMessageDialog(MainFrame.this, message, "Vehicle details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Vehicle not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        modifyVehicle.addActionListener(e -> {
            String plateNumber = JOptionPane.showInputDialog("Enter the license plate number:");
            if (plateNumber == null) {
                return;
            }
            plateNumber = plateNumber.trim();
            if (plateNumber.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The license plate number cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Vehicle foundVehicle = dealership.searchVehicleByPlate(plateNumber);
            if (foundVehicle != null) {
                String newPlateNumber = JOptionPane.showInputDialog("Enter the new license plate number:");
                if (newPlateNumber == null) {
                    return;
                }
                newPlateNumber = newPlateNumber.trim();

                String newBrand = JOptionPane.showInputDialog("Enter the new brand:");
                if (newBrand == null) {
                    return;
                }
                newBrand = newBrand.trim();

                String newModel = JOptionPane.showInputDialog("Enter the new model:");
                if (newModel == null) {
                    return;
                }
                newModel = newModel.trim();

                String newYear = JOptionPane.showInputDialog("Enter the new year:");
                if (newYear == null) {
                    return;
                }
                newYear = newYear.trim();
                dealership.modifyVehicle(plateNumber, newPlateNumber, foundVehicle.getType(), newBrand, newModel, newYear);
                JOptionPane.showMessageDialog(MainFrame.this, "Vehicle successfully modified!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Vehicle not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        registerClient.addActionListener(e -> {
            String clientId = JOptionPane.showInputDialog("Enter the client ID:");
            if (clientId == null) {
                return;
            }
            clientId = clientId.trim();
            if (clientId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The client ID must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String clientName = JOptionPane.showInputDialog("Enter the client's name:");
            if (clientName == null) {
                return;
            }
            clientName = clientName.trim();
            if (clientName.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The client name must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String[] clientTypes = { "SSN", "EIN" };
            int selectedType = JOptionPane.showOptionDialog(
                    MainFrame.this,
                    "Select the client type:",
                    "Client type",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    clientTypes,
                    clientTypes[0]
            );
            if (selectedType == -1) {
                return;
            }
            ClientType clientType = (selectedType == 0) ? ClientType.SSN : ClientType.EIN;
            dealership.registerClient(clientId, clientName, clientType);
            JOptionPane.showMessageDialog(MainFrame.this, "Client successfully registered!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        });
        searchClientById.addActionListener(e -> {
            String clientId = JOptionPane.showInputDialog("Enter the ID of the client you want to search:");
            if (clientId == null) {
                return;
            }
            clientId = clientId.trim();
            if (clientId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The client ID must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Client client = dealership.searchClientById(clientId);
            if (client != null) {
                String clientInfo = "Name: " + client.getName() + "\n" +
                        "Client ID: " + client.getClientId() + "\n" +
                        "Client type: " + client.getType();
                JOptionPane.showMessageDialog(MainFrame.this, clientInfo, "Client information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Client not found.", "Client not found", JOptionPane.WARNING_MESSAGE);
            }
        });
        searchClientByName.addActionListener(e -> {
            String partialName = JOptionPane.showInputDialog("Enter the name of the client you want to search:");
            if (partialName == null) {
                return;
            }
            partialName = partialName.trim();
            if (partialName.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The client name must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Client> matchingClients = dealership.searchClientsByPartialName(partialName);
            if (!matchingClients.isEmpty()) {
                StringBuilder clientInfo = new StringBuilder("Clients found:\n");
                for (Client client : matchingClients) {
                    clientInfo.append("Name: ").append(client.getName()).append("\nClient ID: ").append(client.getClientId()).append("\nType: ").append(client.getType()).append("\n\n");
                }
                JOptionPane.showMessageDialog(MainFrame.this, clientInfo.toString(), "Client information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "No client found based on the part of the name provided.", "Client not found", JOptionPane.WARNING_MESSAGE);
            }
        });

        modifyClient.addActionListener(e -> {
            String clientId = JOptionPane.showInputDialog("Enter the ID of the client you want to modify:");
            if (clientId == null) {
                return;
            }
            clientId = clientId.trim();
            if (clientId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "The client ID must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Client client = dealership.searchClientById(clientId);
            if (client != null) {
                String newName = JOptionPane.showInputDialog("Enter the client new name:");
                if (newName == null) {
                    return;
                }
                newName = newName.trim();
                if (newName.isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this, "The new client name must not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] clientTypes = { "SSN", "EIN" };
                String selectedType = (String) JOptionPane.showInputDialog(MainFrame.this, "Select the new client type:",
                        "Choose the Client Type", JOptionPane.QUESTION_MESSAGE, null, clientTypes, clientTypes[0]);
                if (selectedType == null) {
                    return;
                }
                ClientType newType = ClientType.valueOf(selectedType);
                dealership.modifyClient(clientId, newName, newType);
                JOptionPane.showMessageDialog(MainFrame.this, "Client successfully modified.", "Modified Client", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Client not found.", "Client not found", JOptionPane.WARNING_MESSAGE);
            }
        });
        showInfoButton.addActionListener(e -> {
            StringBuilder infoMessage = new StringBuilder("Vehicles registered:\n");
            for (Vehicle vehicle : dealership.getVehicles()) {
                infoMessage.append("Plate: ").append(vehicle.getPlateNumber()).append(", ");
                infoMessage.append("Type: ").append(vehicle.getType()).append(", ");
                infoMessage.append("Brand: ").append(vehicle.getBrand()).append(", ");
                infoMessage.append("Model: ").append(vehicle.getModel()).append("\n");
            }

            infoMessage.append("\nRegistered clients:\n");
            for (Client client : dealership.getClients()) {
                infoMessage.append("ID: ").append(client.getClientId()).append(", ");
                infoMessage.append("Name: ").append(client.getName()).append(", ");
                infoMessage.append("Typo: ").append(client.getType()).append("\n");
            }

            JOptionPane.showMessageDialog(MainFrame.this, infoMessage.toString(), "Registered Vehicles and Clients", JOptionPane.INFORMATION_MESSAGE);
        });
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}