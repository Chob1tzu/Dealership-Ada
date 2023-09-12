package Dealership.Interface;

import Dealership.Class.CarDealership;
import Dealership.Class.RentService;

import java.util.Date;

public interface PriceServiceInt {
    double rentPrice(CarDealership dealership, RentService rentService, String plateNumber, Date returnDate);
}
