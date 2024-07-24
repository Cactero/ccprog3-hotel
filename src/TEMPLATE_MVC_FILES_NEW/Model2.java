package TEMPLATE_MVC_FILES_NEW;

import Model.Hotel;
import mainMenu.MainMenuModel;

import javax.swing.*;
import java.util.ArrayList;

public class Model2 {
    private ArrayList<Hotel> hotels;
    private Controller2 controller;
    private Model model;

    public Model2(ArrayList<Hotel> hotels, JFrame frame, Model model){
        this.model = model;
        this.hotels = hotels;
        controller = new Controller2(this, (ActualFrame) frame);
    }

    // this is required so Controller has access to the hotels arraylist without explicitly passing it through "new Controller()"
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public Controller2 getController() {
        return controller;
    }

    // create methods with only creating new MODEL objects.
    // Model objects will make Controller, then Controller will make View, so dependent yung entire program on creating Model objects

    // when done, kindly check ChooseHotelModel hehe implement mo yung nandon, sana naka2long mwa
}