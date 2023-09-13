package Dealership;

import Dealership.Class.Client;
import Dealership.Class.Dealership;
import Dealership.Class.Vehicle;
import Dealership.Enum.VehicleType;
import Dealership.Enum.ClientType;
import javax.swing.*;
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
    public MainFrame() {
//      Informações sobre o mainFrame
        JFrame jFrame = new JFrame();
        setContentPane(mainPanel);
        setTitle("Dealership Ada");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        dialogoBox.setText("Olá " + System.getProperty("user.name") + ", seja bem-vindo ao Dealership Ada!");

        registerVehicleButton.addActionListener(e -> {
            String vehicleId = JOptionPane.showInputDialog(jFrame, "Informe o ID do veículo:");
            if (vehicleId == null) {
                return;
            }
            vehicleId = vehicleId.trim();
            if (vehicleId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O ID do veículo não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            VehicleType type = VehicleType.valueOf(JOptionPane.showInputDialog("Informe o tipo de veículo (SMALL, MEDIUM, SUV):"));
            String brand = JOptionPane.showInputDialog(jFrame, "Informe a marca do veículo:");
            if (brand == null) {
                return;
            }
            brand = brand.trim();
            if (brand.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "A marca do veículo não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String model = JOptionPane.showInputDialog(jFrame, "Informe o modelo do veículo:");
            if (model == null) {
                return;
            }
            model = model.trim();
            if (model.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O modelo do veículo não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String year = JOptionPane.showInputDialog(jFrame, "Informe o ano do veículo:");
            if (year == null) {
                return;
            }
            year = year.trim();
            if (year.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O ano do veículo não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String color = JOptionPane.showInputDialog(jFrame, "Informe a cor do veículo:");
            if (color == null) {
                return;
            }
            color = color.trim();
            if (color.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "A cor do veículo não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            dealership.registerVehicle(vehicleId, type, brand, model, year, color);
        });
        searchVehicleByPlate.addActionListener(e -> {
            String plateNumber = JOptionPane.showInputDialog("Informe o número da placa do veículo:");
            if (plateNumber == null) {
                return;
            }
            plateNumber = plateNumber.trim();
            if (plateNumber.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O número da placa não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Vehicle foundVehicle = dealership.searchVehicleByPlate(plateNumber);
            if (foundVehicle != null) {
                String message = "Detalhes do Veículo:\n" + "Placa: " + foundVehicle.getPlateNumber() + "\n" +
                        "Tipo: " + foundVehicle.getType() + "\n" +
                        "Marca: " + foundVehicle.getBrand() + "\n" +
                        "Modelo: " + foundVehicle.getModel() + "\n" +
                        "Ano: " + foundVehicle.getYear() + "\n" +
                        "Cor: " + foundVehicle.getColor() + "\n";

                JOptionPane.showMessageDialog(MainFrame.this, message, "Detalhes do Veículo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        modifyVehicle.addActionListener(e -> {
            String plateNumber = JOptionPane.showInputDialog("Informe o número da placa do veículo que deseja modificar:");
            if (plateNumber == null) {
                return;
            }
            plateNumber = plateNumber.trim();
            if (plateNumber.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O número da placa não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Vehicle foundVehicle = dealership.searchVehicleByPlate(plateNumber);
            if (foundVehicle != null) {
                String newPlateNumber = JOptionPane.showInputDialog("Informe o novo número da placa:");
                if (newPlateNumber == null) {
                    return;
                }
                newPlateNumber = newPlateNumber.trim();

                String newBrand = JOptionPane.showInputDialog("Informe a nova marca:");
                if (newBrand == null) {
                    return;
                }
                newBrand = newBrand.trim();

                String newModel = JOptionPane.showInputDialog("Informe o novo modelo:");
                if (newModel == null) {
                    return;
                }
                newModel = newModel.trim();

                String newYear = JOptionPane.showInputDialog("Informe o novo ano:");
                if (newYear == null) {
                    return;
                }
                newYear = newYear.trim();
                dealership.modifyVehicle(plateNumber, newPlateNumber, foundVehicle.getType(), newBrand, newModel, newYear);
                JOptionPane.showMessageDialog(MainFrame.this, "Veículo modificado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        registerClient.addActionListener(e -> {
            String clientId = JOptionPane.showInputDialog("Informe o ID do cliente:");
            if (clientId == null) {
                return;
            }
            clientId = clientId.trim();
            if (clientId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O ID do cliente não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String clientName = JOptionPane.showInputDialog("Informe o nome do cliente:");
            if (clientName == null) {
                return;
            }
            clientName = clientName.trim();
            if (clientName.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O nome do cliente não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String[] clientTypes = { "SSN", "EIN" };
            int selectedType = JOptionPane.showOptionDialog(
                    MainFrame.this,
                    "Selecione o tipo de cliente:",
                    "Tipo de Cliente",
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
            JOptionPane.showMessageDialog(MainFrame.this, "Cliente registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        });
        searchClientById.addActionListener(e -> {
            String clientId = JOptionPane.showInputDialog("Informe o ID do cliente que deseja buscar:");
            if (clientId == null) {
                return;
            }
            clientId = clientId.trim();
            if (clientId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O ID do cliente não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Client client = dealership.searchClientById(clientId);
            if (client != null) {
                String clientInfo = "Nome: " + client.getName() + "\n" +
                        "ID do Cliente: " + client.getClientId() + "\n" +
                        "Tipo de Cliente: " + client.getType();
                JOptionPane.showMessageDialog(MainFrame.this, clientInfo, "Informações do Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Cliente não encontrado.", "Cliente não encontrado", JOptionPane.WARNING_MESSAGE);
            }
        });
        searchClientByName.addActionListener(e -> {
            String clientName = JOptionPane.showInputDialog("Informe o nome do cliente que deseja buscar:");
            if (clientName == null) {
                return;
            }
            clientName = clientName.trim();
            if (clientName.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O nome do cliente não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Client client = dealership.searchClientByName(clientName);
            if (client != null) {
                String clientInfo = "Nome: " + client.getName() + "\n" +
                        "ID do Cliente: " + client.getClientId() + "\n" +
                        "Tipo de Cliente: " + client.getType();
                JOptionPane.showMessageDialog(MainFrame.this, clientInfo, "Informações do Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Cliente não encontrado.", "Cliente não encontrado", JOptionPane.WARNING_MESSAGE);
            }
        });
        modifyClient.addActionListener(e -> {
            String clientId = JOptionPane.showInputDialog("Informe o ID do cliente que deseja modificar:");
            if (clientId == null) {
                return;
            }
            clientId = clientId.trim();
            if (clientId.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.this, "O ID do cliente não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Client client = dealership.searchClientById(clientId);
            if (client != null) {
                String newName = JOptionPane.showInputDialog("Informe o novo nome do cliente:");
                if (newName == null) {
                    return;
                }
                newName = newName.trim();
                if (newName.isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this, "O novo nome do cliente não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] clientTypes = { "SSN", "EIN" };
                String selectedType = (String) JOptionPane.showInputDialog(MainFrame.this, "Selecione o novo tipo de cliente:",
                        "Escolha o Tipo de Cliente", JOptionPane.QUESTION_MESSAGE, null, clientTypes, clientTypes[0]);
                if (selectedType == null) {
                    return;
                }
                ClientType newType = ClientType.valueOf(selectedType);
                dealership.modifyClient(clientId, newName, newType);
                JOptionPane.showMessageDialog(MainFrame.this, "Cliente modificado com sucesso.", "Cliente Modificado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.this, "Cliente não encontrado.", "Cliente não encontrado", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}