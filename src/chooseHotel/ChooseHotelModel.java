package chooseHotel;

import Model.CentralModel;
import Model.Hotel;
import createRoom.CreateRoomModel;
import enterHotelName.EnterHotelNameModel;
import main.AbstractModel;
import main.MainFrame;
import removeRoom.RemoveRoomModel;
import shared.SelectableHotel;
import viewHotel.ViewHotelModel;

import java.util.HashMap;

/**
 * The Model for Choose Hotel
 * @author Angela Domingo
 */
public class ChooseHotelModel extends AbstractModel {

    private String source;

    //manage hotel macros
    public static final String ADD_ROOMS = "Add Rooms";
    public static final String REMOVE_ROOMS = "Remove Room";
    public static final String CHANGE_HOTEL_NAME = "Change Hotel Name";
    public static final String UPDATE_BASE_PRICE = "Update Base Price";
    public static final String REMOVE_RESERVATION = "Remove Reservation";
    public static final String REMOVE_HOTEL = "Remove Hotel";
    public static final String CHANGE_ROOM_TYPE = "Change Room Type";
    public static final String DATE_PRICE_MODIFIER = "Date Price Modifier";

    // miscellaneous macros for screens that require hotel selection
    public static final String CREATE_RESERVATION = "Create Reservation";
    public static final String VIEW_HOTEL = "View Hotel";

    private HashMap<String, AbstractModel> models;

    public ChooseHotelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        controller = new ChooseHotelController(this, frame);
        models = new HashMap<>();

        models.put(ADD_ROOMS, new CreateRoomModel(centralModel, frame, false));
        models.put(REMOVE_ROOMS, new RemoveRoomModel(centralModel, frame));
        models.put(CHANGE_HOTEL_NAME, new EnterHotelNameModel(centralModel, frame, false));
        models.put(UPDATE_BASE_PRICE, new CreateRoomModel(centralModel, frame, false));
        models.put(REMOVE_RESERVATION, new CreateRoomModel(centralModel, frame, false));
        models.put(REMOVE_HOTEL, new CreateRoomModel(centralModel, frame, false));
        models.put(CHANGE_ROOM_TYPE, new CreateRoomModel(centralModel, frame, false));
        models.put(DATE_PRICE_MODIFIER, new CreateRoomModel(centralModel, frame, false));
        models.put(CREATE_RESERVATION, new CreateRoomModel(centralModel, frame, false));
        models.put(VIEW_HOTEL, new ViewHotelModel(centralModel, frame));

    }

    /**
     * A setter for the source of where Choose Hotel was triggered.
     * @param source the source where Choose Hotel was triggered, used by passing through static final variables found inside Choose Model
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * A getter for the source of where Choose Hotel was triggered.
     * @return the source where Choose Hotel was triggered
     */
    public String getSource() {
        return source;
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     * @return the Model of Main Menu
     */
    public AbstractModel mainMenu(){
        return centralModel.getModel(CentralModel.MAIN_MENU);
    }

    /**
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     * @return the Model of Manage Hotel
     */
    public AbstractModel manageHotel(){
        return centralModel.getModel(CentralModel.MANAGE_HOTEL);
    }

    /**
     * Retrieves the desired Model from a HashMap created in Choose Hotel Model
     * @param selectedHotel the Hotel selected by the user
     * @param key lookup value for desired Model, uses ChooseHotelModel macros
     * @return the desired Model depending on the passed key value
     */
    public AbstractModel getModel(Hotel selectedHotel, String key){
        SelectableHotel currentModel = (SelectableHotel) this.models.get(key);
        currentModel.setSelectedHotel(selectedHotel);
        return (AbstractModel) currentModel;
    }
}
