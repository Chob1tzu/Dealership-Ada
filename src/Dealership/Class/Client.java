package Dealership.Class;

import Dealership.Enum.ClientType;

public class Client {
    private String name;
    private String id;
    private ClientType type;

    public Client(String id, ClientType type) {
        this.id = id;
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }
}
