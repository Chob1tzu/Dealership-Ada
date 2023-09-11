package Dealership.Class;

import Dealership.Enum.ClientType;

public class Client {
    private String id;
    private ClientType type;

    public Client(String id, ClientType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public ClientType getType() {
        return type;
    }
}