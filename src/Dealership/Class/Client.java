package Dealership.Class;

import Dealership.Enum.ClientType;

public class Client {
    private String name;
    private String id;
    private ClientType type;

    public Client(String name,String id, ClientType type) {
        this.name = name;
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