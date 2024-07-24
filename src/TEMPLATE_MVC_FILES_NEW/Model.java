package TEMPLATE_MVC_FILES_NEW;

import Model.Hotel;
import mainMenu.MainMenuModel;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Hotel> hotels;
    private Controller controller;

    private Model2 model2;

    public Model(ArrayList<Hotel> hotels, JFrame frame, Model2 model2){
        this.hotels = hotels;
        this.model2 = model2;
        controller = new Controller(this, (ActualFrame) frame);
    }

    // this is required so Controller has access to the hotels arraylist without explicitly passing it through "new Controller()"
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public Controller getController() {
        return controller;
    }

    // create methods with only creating new MODEL objects.
    // Model objects will make Controller, then Controller will make View, so dependent yung entire program on creating Model objects

    // when done, kindly check ChooseHotelModel hehe implement mo yung nandon, sana naka2long mwa
}
