package Dealership.Class;

import Dealership.Enum.ClientType;

public class Client {
    private String name;
    private String clientId;
    private ClientType type;

    public Client(String name, String clientId, ClientType type) {
        this.name = name;
        this.clientId = clientId;
        this.type = type;
    }

    public String getClientId() {
        return clientId;
    }

    public ClientType getType() {
        return type;
    }
}