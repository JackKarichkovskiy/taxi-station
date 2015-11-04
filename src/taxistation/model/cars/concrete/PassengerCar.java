/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.model.cars.concrete;

import taxistation.model.cars.AbstractCar;
import taxistation.utils.TaxiStationUtils;

/**
 * Class represents the passenger car.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class PassengerCar extends AbstractCar {

    /**
     * The count of passengers that car can tote.
     */
    private int passengerCount;

    /**
     * Empty constructor.
     */
    public PassengerCar() {
    }

    /**
     * Constructor for all fields initialization.
     * @param passengerCount - count of passengers
     * @param model - name of model
     * @param hp - horse power
     * @param fuelConsumption - fuel consumption
     * @param price - cost of the car
     * @param maxSpeed - maximum speed of car
     * @param engineType - type of car engine
     */
    public PassengerCar(int passengerCount, String model, int hp, int fuelConsumption, int price, int maxSpeed, EngineType engineType) {
        super(model, hp, fuelConsumption, price, maxSpeed, engineType);
        this.passengerCount = passengerCount;
    }

    @Override
    public int maxSpeed() {
        return maxSpeed;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = TaxiStationUtils.checkNotNegative(passengerCount);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 79 * hash + this.passengerCount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PassengerCar other = (PassengerCar) obj;
        if (this.passengerCount != other.passengerCount) {
            return false;
        }
        return super.equals(obj);
    }

    
    
    @Override
    public String toString() {
        return "PassengerCar{" + "passengerCount=" + passengerCount + '}' + super.toString();
    }

}
