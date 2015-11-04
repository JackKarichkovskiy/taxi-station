/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.view.interfaces;

/**
 * Interface that represents the View in MVC pattern.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public interface View {

    /**
     * Method outputs message to the view.
     *
     * @param message - message that needs to be outputted
     */
    void viewMessage(String message);

    /**
     * Method get some string from the view.
     *
     * @return the inputted string
     */
    String getInputString();

    /**
     * Method clears the View.
     */
    void clear();
}
