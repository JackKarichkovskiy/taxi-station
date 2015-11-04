/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import taxistation.model.cars.AbstractCar;
import taxistation.utils.Accumulator;
import taxistation.utils.TaxiStationUtils;

/**
 * Class that represents the taxi station entity.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class TaxiStation {

    /**
     * List that contains cars in the taxi station.
     */
    private List<AbstractCar> cars = new ArrayList<>();

    /**
     * Object that counts the cost of all cars in the station.
     */
    private Accumulator stationCost = new Accumulator();

    /**
     * Method add a new car to the station catalog.
     *
     * @param newCar - the new car that needs to be added
     * @throws IllegalArgumentException if (newCar == null)
     */
    public void addCar(AbstractCar newCar) {
        TaxiStationUtils.checkNotNull(newCar);
        
        stationCost.add(newCar.cost());
        cars.add(newCar);
    }

    /**
     * Method remove an existed car from the station catalog.
     *
     * @param car - car that needs to be removed
     * @return true if the list of cars contains the car and was successfully
     * removed, else - false.
     * @throws IllegalArgumentException if (car == null)
     */
    public boolean removeCar(AbstractCar car) {
        TaxiStationUtils.checkNotNull(car);

        stationCost.add(-car.cost());
        return cars.remove(car);
    }

    /**
     * Method returns the summary cost of all taxi station cars.
     *
     * @return summary cost of station
     */
    public int getTaxiStationCost() {
        return stationCost.getSum();
    }

    /**
     * Method sorts cars by fuel consumption.
     */
    public void sortCarsByFuelConsumption() {
        cars.sort((car1, car2) -> car1.fuelConsumption() - car2.fuelConsumption());
    }

    /**
     * Method finds car with the max speed in range of [speedMin:speedMax].
     *
     * @param speedMin - the lower range
     * @param speedMax - the upper range
     * @return the first founded car object or <strong>null</strong> if the car
     * wasn't founded
     */
    public AbstractCar findCarWithSpeedInRangeOf(int speedMin, int speedMax) {
        Optional<AbstractCar> result = cars.stream().filter((car) -> speedMin <= car.maxSpeed() && car.maxSpeed() <= speedMax).findFirst();
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public String toString() {
        String result = "TaxiStation{";
        for (AbstractCar car : cars) {
            result += "\n" + car.toString();
        }
        result += "\n}";
        return result;
    }

    /**
     * Method returns the count of all cars in taxi station.
     * @return count of cars in taxi station
     */
    public int getCarCount() {
        return cars.size();
    }

    /**
     * Method returns the copy of list with cars in taxi station.
     * @return cloned list with existed cars
     */
    public List<AbstractCar> getCars() {
        return new ArrayList<>(cars);
    }

    /**
     * Method clears the data of taxi station.
     */
    public void clear() {
        cars.clear();
        stationCost.clear();
    }

}
