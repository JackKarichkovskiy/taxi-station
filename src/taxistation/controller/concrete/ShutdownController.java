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
 * Class that controls the shutdowning of the application.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
class ShutdownController extends AbstractTaxiStationController {

    public ShutdownController(View view, TaxiStation station) {
        super(view, station);
    }

    @Override
    public void execute() {
        view.viewMessage(ENGMessages.SHUTDOWN_MESSAGE);
        view.clear();
        station.clear();
        System.exit(0);
    }

}
