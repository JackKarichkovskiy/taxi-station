/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.view.localization;

/**
 * Interface that contains different localized messages or labels.
 *
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public interface ENGMessages {

    String WELCOME_MESSAGE = "Welcome to the TaxiStation Application!";

    String ENTER_COMMAND_MESSAGE = "Please enter one of the commands: q-quit, s-sort, f-find, c-cost of station";

    String IO_EXCEPTION = "Sorry, some IO problems. Please try again.";

    String WRONG_COMMAND = "Wrong! It's not an existed command.";

    String NULL_COMMAND = "Wrong! Please enter any command.";

    String STATION_COST = "The cost of taxi station is %s";

    String NUMBER_FORMAT_EXCEPTION = "It's not a number. Please try again.";

    String ENTER_SPEED_MIN = "Please enter the lower range of speed(inclusive):";

    String ENTER_SPEED_MAX = "Please enter the upper range of speed(inclusive):";

    String CAR_NOT_FOUND = "Sorry, but car from your request wasn't found.";

    String SHUTDOWN_MESSAGE = "Shutdown...";
}
