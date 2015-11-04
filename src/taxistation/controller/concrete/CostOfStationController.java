/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.controller.concrete;

import taxistation.controller.AbstractTaxiStationController;
import taxistation.model.TaxiStation;
import taxistation.view.interfaces.View;
import taxistation.view.localization.ENGMessages;

/**
 * Class that controls the calculation of taxi station cost.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
class CostOfStationController extends AbstractTaxiStationController {

    public CostOfStationController(View view, TaxiStation station) {
        super(view, station);
    }

    @Override
    public void execute() {
        int taxiStationCost = station.getTaxiStationCost();
        view.viewMessage(String.format(ENGMessages.STATION_COST, taxiStationCost));
    }

}
