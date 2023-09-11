package Dealership.Interface;

import Dealership.Class.Client;
import Dealership.Class.Vehicle;
import java.util.Date;

public interface RentalService {
    void rentVehicle(Client client, Vehicle vehicle, Date rentDate, int rentalDays);
    void returnVehicle(Client client, Vehicle vehicle, Date returnDate);
}
