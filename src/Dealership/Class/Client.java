package Dealership.Class;

import Dealership.Enum.ClientType;

public class Client {
    protected String name;
    protected String clientId;
    protected ClientType type;

    Client(String clientId, String name, ClientType type) {
        this.clientId = clientId;
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }

    void setName(String name) { this.name = name; }

    public String getClientId() { return clientId; }

    void setClientId(String clientId) { this.clientId = clientId; }

    public ClientType getType() {
        return type;
    }

    void setType(ClientType type) { this.type = type; }
}