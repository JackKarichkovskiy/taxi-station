/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.model.cars.interfaces;

/**
 * Interface that represents the car entity.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public interface Car {

    /**
     * The limit of speed in city for cars.
     */
    int CITY_LIMIT = 60;

    /**
     * Method returns the name of the car.
     *
     * @return name of car
     */
    String name();

    /**
     * Method returns the max speed of car
     *
     * @return max speed of car
     */
    int maxSpeed();

    /**
     * Method returns the horse power of car
     *
     * @return horse power of car
     */
    int hp();

    /**
     * Method returns the fuel consumption of car
     *
     * @return fuel consumption of car
     */
    int fuelConsumption();
}
