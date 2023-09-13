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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getClientId() { return clientId; }

    public void setClientId(String clientId) { this.clientId = clientId; }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) { this.type = type; }
}