/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation;

import taxistation.controller.concrete.ConsoleController;
import taxistation.model.TaxiStation;
import taxistation.model.cars.AbstractCar;
import taxistation.model.cars.concrete.PassengerCar;
import taxistation.view.concrete.ConsoleView;
import taxistation.view.interfaces.View;

/**
 * Class initializes model and view and respond it to the main controller.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaxiStation station = new TaxiStation();
        station.addCar(new PassengerCar(5, "Audi", 200, 40, 30500, 240, AbstractCar.EngineType.Petrol));
        station.addCar(new PassengerCar(6, "Honda", 180, 35, 30100, 200, AbstractCar.EngineType.Petrol));
        station.addCar(new PassengerCar(4, "BMW", 220, 60, 40000, 260, AbstractCar.EngineType.Petrol));
        
        View view = new ConsoleView();
        
        new ConsoleController(view, station).execute();
    }
    
}
