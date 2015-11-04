/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.controller;

import taxistation.model.TaxiStation;
import taxistation.utils.TaxiStationUtils;
import taxistation.view.interfaces.View;

/**
 * Abstract class that represents the structure of all controllers.
 * Controllers need to save view and model.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public abstract class AbstractTaxiStationController implements Controller{
    
    /**
     * The View in the MVC pattern.
     */
    protected View view;
    
    /**
     * The Model in the MVC pattern.
     */
    protected TaxiStation station;
    
    /**
     * Constructor that take the view and the model of MVC pattern.
     * @param view - view in the MVC pattern
     * @param station - model of MVC pattern
     */
    protected AbstractTaxiStationController(View view, TaxiStation station) {
        this.view = TaxiStationUtils.checkNotNull(view);
        this.station = TaxiStationUtils.checkNotNull(station);
    }
    
}
