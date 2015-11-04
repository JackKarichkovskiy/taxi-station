/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.utils;

/**
 * Class contains different helpful functions that used threw over the system.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class TaxiStationUtils {

    /**
     * Method checks the input value by negativity. If input value is negative
     * the method inverse it to positive.
     *
     * @param value - value that needs to be checked
     * @return input value or its inverse value
     */
    public static final int checkNotNegative(int value) {
        return value < 0 ? Math.abs(value) : value;
    }

    /**
     * Method checks the object by null equality.
     *
     * @param <T> - type of object
     * @param obj - object that needs to be checked
     * @return the origin value
     * @throws IllegalArgumentException if (object == null)
     */
    public static final <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }

        return obj;
    }
}
