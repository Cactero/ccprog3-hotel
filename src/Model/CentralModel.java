package Model;

import java.util.ArrayList;
import java.util.HashMap;

import chooseHotel.ChooseHotelModel;
import enterHotelName.EnterHotelNameModel;
import shared.AbstractModel;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

/**
 * The database of the program.
 * @author Angela Domingo
 */
public class CentralModel {

    private ArrayList<Hotel> hotels;
    private HashMap<String, AbstractModel> models;

    public static final String MAIN_MENU = "Main Menu";
    public static final String CREATE_HOTEL = "Create Hotel";
    public static final String CHOOSE_HOTEL = "Choose Hotel";
    public static final String MANAGE_HOTEL = "Manage Hotel";


    public CentralModel(MainFrame frame){
        this.hotels = new ArrayList<>();
        this.models = new HashMap<>();

        // initializes the most used models in the program that have the most "unique" states
        models.put(MAIN_MENU, new MainMenuModel(this, frame));
        models.put(CREATE_HOTEL, new EnterHotelNameModel(this, frame, true));
        models.put(CHOOSE_HOTEL, new ChooseHotelModel(this, frame));
        models.put(MANAGE_HOTEL, new ManageHotelModel(this, frame));
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }

    public void removeHotel(Hotel hotel){
        this.hotels.remove(hotel);
    }

    public Hotel getHotel(int index){
        return this.hotels.get(index);
    }

    public AbstractModel getModel(String key){
        return models.get(key);
    }

}
