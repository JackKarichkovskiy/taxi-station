/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.controller.concrete;

import taxistation.controller.AbstractTaxiStationController;
import taxistation.model.TaxiStation;
import taxistation.model.cars.AbstractCar;
import taxistation.view.interfaces.View;
import taxistation.view.localization.ENGMessages;

/**
 * Class that controls the function of finding the car by its max speed.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class FindCarController extends AbstractTaxiStationController {

    public FindCarController(View view, TaxiStation station) {
        super(view, station);
    }

    @Override
    public void execute() {
        int speedMin = 0;
        int speedMax = 0;

        while (true) {
            view.viewMessage(ENGMessages.ENTER_SPEED_MIN);
            String inputString = view.getInputString();
            try {
                speedMin = Integer.valueOf(inputString);
            } catch (NumberFormatException e) {
                view.viewMessage(ENGMessages.NUMBER_FORMAT_EXCEPTION);
                continue;
            }
            break;
        }

        while (true) {
            view.viewMessage(ENGMessages.ENTER_SPEED_MAX);
            String inputString = view.getInputString();
            try {
                speedMax = Integer.valueOf(inputString);
            } catch (NumberFormatException e) {
                view.viewMessage(ENGMessages.NUMBER_FORMAT_EXCEPTION);
                continue;
            }
            break;
        }

        if(speedMin > speedMax){
            int temp = speedMin;
            speedMin = speedMax;
            speedMax = temp;
        }
        
        AbstractCar resultCar = station.findCarWithSpeedInRangeOf(speedMin, speedMax);

        if (resultCar == null) {
            view.viewMessage(ENGMessages.CAR_NOT_FOUND);
        } else {
            view.viewMessage(resultCar.toString());
        }
    }

}
