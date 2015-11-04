/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.utils;

/**
 * Class that can store and count some value.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class Accumulator {

    /**
     * Value that counts and stores.
     */
    private int sum;

    /**
     * Method adds some value to the stored sum.
     *
     * @param value - value that needs to be added
     */
    public void add(int value) {
        sum += value;
    }

    /**
     * Method returns the current sum that stored.
     *
     * @return current sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * Method reset the stored value.
     */
    public void clear() {
        sum = 0;
    }

}
