package Dealership.Class;

import Dealership.Enum.ClientType;

public class Client {
    protected String name;
    protected String clientId;
    protected ClientType type;

    public Client(String clientId, String name, ClientType type) {
        this.clientId = clientId;
        this.name = name;
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