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
 * Class that controls the console work and delegate the work to another controllers.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class ConsoleController extends AbstractTaxiStationController {

    
    public ConsoleController(View view, TaxiStation station) {
        super(view, station);
    }

    @Override
    public void execute() {
        view.viewMessage(ENGMessages.WELCOME_MESSAGE);
        while (true) {
            view.viewMessage(String.format(ENGMessages.ENTER_COMMAND_MESSAGE));
            String userInput = view.getInputString();
            
            if(userInput == null){
                view.viewMessage(ENGMessages.NULL_COMMAND);
                continue;
            }

            switch (userInput) {
                case "c":
                    new CostOfStationController(view, station).execute();
                    break;
                case "f":
                    new FindCarController(view, station).execute();
                    break;
                case "s":
                    new SortTaxiStationController(view, station).execute();
                    break;
                case "q":
                    new ShutdownController(view, station).execute();
                    break;
                default:
                    view.viewMessage(ENGMessages.WRONG_COMMAND);
                    break;
            }
        }
    }

}
