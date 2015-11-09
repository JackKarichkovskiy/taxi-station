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

    public enum UserCommands{
        COST, FIND, SORT, QUIT
    }
    
    public ConsoleController(View view, TaxiStation station) {
        super(view, station);
    }

    @Override
    public void execute() {
        view.viewMessage(ENGMessages.WELCOME_MESSAGE);
        while (true) {
            view.viewMessage(String.format(ENGMessages.ENTER_COMMAND_MESSAGE));
            String strUserInput = view.getInputString();
            
            UserCommands userInput = null;
            try{
                userInput = UserCommands.valueOf(strUserInput.toUpperCase());
            }catch(IllegalArgumentException e){
                view.viewMessage(ENGMessages.WRONG_COMMAND);
                continue;
            }
            
            if(userInput == null){
                view.viewMessage(ENGMessages.NULL_COMMAND);
                continue;
            }

            switch (userInput) {
                case COST:
                    new CostOfStationController(view, station).execute();
                    break;
                case FIND:
                    new FindCarController(view, station).execute();
                    break;
                case SORT:
                    new SortTaxiStationController(view, station).execute();
                    break;
                case QUIT:
                    new ShutdownController(view, station).execute();
                    break;
                default:
                    view.viewMessage(ENGMessages.WRONG_COMMAND);
                    break;
            }
        }
    }

}
