package main;

import Model.CentralModel;
import Model.Hotel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class AbstractModel {

    protected CentralModel centralModel;
    protected AbstractController controller;

    public AbstractModel(CentralModel centralModel){
        this.centralModel = centralModel;
    }

    public ArrayList<Hotel> getHotels(){
        return centralModel.getHotels();
    }

    public JPanel getContentHolder(){
        return controller.getContentHolder();
    }

    public AbstractController getController() {
        return controller;
    }
}
