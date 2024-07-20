package TEMPLATE_MVC_FILES_ORIGINAL;

import app.Hotel;
import mainMenu.MainMenuModel;

import java.util.ArrayList;

public class Model {
    private ArrayList<Hotel> hotels;

    public Model(ArrayList<Hotel> hotels){
        this.hotels = hotels;
        new Controller(this);
    }

    // this is required so Controller has access to the hotels arraylist without explicitly passing it through "new Controller()"
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    // create methods with only creating new MODEL objects.
    // Model objects will make Controller, then Controller will make View, so dependent yung entire program on creating Model objects
    public void mainMenu(){
        // as mentioned earlier sa taas, pass in hotels arraylist para pinapasa yung info sa lahat
        new MainMenuModel(hotels);
    }

    // when done, kindly check ChooseHotelModel hehe implement mo yung nandon, sana naka2long mwa
}
