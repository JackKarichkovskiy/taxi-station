/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.model.cars.interfaces;

/**
 * Interface represents the good entity that can be sold or bought.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public interface Goods {

    /**
     * Method returns the price or cost of some good.
     *
     * @return price of good
     */
    int cost();
}
