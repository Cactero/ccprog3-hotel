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

    /**
     * The database of the program,
     * @param frame the main frame of the program
     */
    public CentralModel(MainFrame frame){
        this.hotels = new ArrayList<>();
        this.models = new HashMap<>();

        // initializes the most used models in the program that have the most "unique" states
        models.put(MAIN_MENU, new MainMenuModel(this, frame));
        models.put(CREATE_HOTEL, new EnterHotelNameModel(this, frame, true));
        models.put(CHOOSE_HOTEL, new ChooseHotelModel(this, frame));
        models.put(MANAGE_HOTEL, new ManageHotelModel(this, frame));
    }

    /**
     * Returns the list of hotels.
     * @return an ArrayList of Hotel objects.
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Adds a new hotel to the list of hotels.
     * @param hotel the Hotel object to add.
     */
    public void addHotel(Hotel hotel) {
        this.hotels.add(hotel);
    }

    /**
     * Removes a hotel from the list of hotels.
     * @param hotel the Hotel object to remove.
     */
    public void removeHotel(Hotel hotel) {
        this.hotels.remove(hotel);
    }

    /**
     * Retrieves a hotel from the list by its index.
     * @param index the index of the Hotel in the list.
     * @return the Hotel object at the specified index.
     */
    public Hotel getHotel(int index) {
        return this.hotels.get(index);
    }

    /**
     * Retrieves a model object associated with the specified key.
     * @param key the key associated with the desired AbstractModel.
     * @return the AbstractModel object associated with the key, or null if no model is associated with the key.
     */
    public AbstractModel getModel(String key) {
        return models.get(key);
    }

}
