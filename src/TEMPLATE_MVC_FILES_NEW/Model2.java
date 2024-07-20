package TEMPLATE_MVC_FILES_NEW;

import app.Hotel;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

public class Model2 {
    private ArrayList<Hotel> hotels;

    public Model2(ArrayList<Hotel> hotels){
        this.hotels = hotels;
    }

    // this is required so Controller has access to the hotels arraylist without explicitly passing it through "new Controller()"
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    // create methods with only creating new MODEL objects.
    // Model objects will make Controller, then Controller will make View, so dependent yung entire program on creating Model objects

    // when done, kindly check ChooseHotelModel hehe implement mo yung nandon, sana naka2long mwa
}