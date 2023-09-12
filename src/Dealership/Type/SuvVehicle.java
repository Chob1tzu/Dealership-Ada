package Dealership.Type;

import Dealership.Class.CarDealership;
import Dealership.Class.RentService;
import Dealership.Class.Vehicle;
import Dealership.Interface.PriceServiceInt;

import java.util.Date;

public class SuvVehicle implements PriceServiceInt {
    @Override
    public double rentPrice(CarDealership dealership, RentService rentService, String plateNumber, Date returnDate) {
        Vehicle vehicle = dealership.searchVehicle(plateNumber);
        if (vehicle.isRented) {
            // Calculate the rental duration in days
            long rentalDuration = (returnDate.getTime() - vehicle.lastRentedDate.getTime()) / (24 * 60 * 60 * 1000);

            // Calculate the rental price based on vehicle type
            double rentalPrice = 0.0;
            switch (vehicle.getType()) {
                case SMALL:
                    rentalPrice = rentalDuration * 100.0;
                    break;
                case MEDIUM:
                    rentalPrice = rentalDuration * 150.0;
                    break;
                case SUV:
                    rentalPrice = rentalDuration * 200.0;
                    break;
            }

            vehicle.setRented();
            vehicle.setLastRentedDate();
            return rentalPrice;
        }
        return 0.0; // Vehicle was not rented
    }
}
