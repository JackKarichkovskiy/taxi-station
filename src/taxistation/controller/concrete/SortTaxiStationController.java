/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.controller.concrete;

import taxistation.controller.AbstractTaxiStationController;
import taxistation.model.TaxiStation;
import taxistation.view.interfaces.View;

/**
 * Class that controls the sorting of the cars in taxi station by its fuel consumption.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class SortTaxiStationController extends AbstractTaxiStationController{

    public SortTaxiStationController(View view, TaxiStation station) {
        super(view, station);
    }
    
    @Override
    public void execute() {
        station.sortCarsByFuelConsumption();
        view.viewMessage(station.toString());
    }
    
}
