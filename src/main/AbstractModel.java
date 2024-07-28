package main;

import Model.CentralModel;
import Model.Hotel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Parent abstract class for all models in the program.
 * @author Angela Domingo
 */
public abstract class AbstractModel {

    protected CentralModel centralModel;
    protected AbstractController controller;

    public AbstractModel(CentralModel centralModel){
        this.centralModel = centralModel;
    }

    /**
     * Retrieves the ArrayList of hotels from the Central Model.
     * @return the ArrayList of hotels in Central Model
     */
    public ArrayList<Hotel> getHotels(){
        return centralModel.getHotels();
    }

    /**
     * Returns the content holder panel.
     * @return the JPanel that holds the content.
     */
    public JPanel getContentHolder(){
        return controller.getContentHolder();
    }

    /**
     * Returns the controller object.
     * @return the Controller assigned to the Model
     */
    public AbstractController getController() {
        return controller;
    }
}
