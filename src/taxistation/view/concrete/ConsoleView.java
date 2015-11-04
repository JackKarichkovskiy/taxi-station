/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxistation.view.concrete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import taxistation.view.interfaces.View;
import taxistation.view.localization.ENGMessages;

/**
 * Class that works with console.
 * 
 * @author Karichkovskiy Yevhen
 * @version 1.0
 * @since 31.10.2015
 */
public class ConsoleView implements View {

    /**
     * The output stream to the console.
     */
    private PrintStream consoleOut = System.out;

    /**
     * The input stream from the console.
     */
    private BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void viewMessage(String message) {
        consoleOut.println(message);
    }

    @Override
    public String getInputString() {
        try {
            return consoleIn.readLine();
        } catch (IOException ex) {
            viewMessage(ENGMessages.IO_EXCEPTION);
        }

        return "";
    }

    @Override
    public void clear() {
        try {
            consoleOut.close();
            consoleIn.close();
        } catch (IOException ex) {
            viewMessage(ENGMessages.IO_EXCEPTION);
        }
    }

}
