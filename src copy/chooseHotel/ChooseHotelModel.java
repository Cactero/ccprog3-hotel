package chooseHotel;

import Model.CentralModel;
import Model.Hotel;
import createReservation.CreateReservationModel;
import createRoom.CreateRoomModel;
import enterHotelName.EnterHotelNameModel;
import main.AbstractModel;
import main.MainFrame;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;
import manageHotel.ManageHotelModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Model for Choose Hotel
 * @author Angela Domingo
 */
public class ChooseHotelModel extends AbstractModel {

    private String source;

    private AbstractModel addRooms, removeRooms, changeHotelName, updateBasePrice, removeReservation, removeHotel, changeRoomType;

    public static final String ADD_ROOMS = "Add Rooms";
    public static final String REMOVE_ROOMS = "Remove Room";
    public static final String CHANGE_HOTEL_NAME = "Change Hotel Name";
    public static final String UPDATE_BASE_PRICE = "Update Base Price";
    public static final String REMOVE_RESERVATION = "Remove Reservation";
    public static final String REMOVE_HOTEL = "Remove Hotel";
    public static final String CHANGE_ROOM_TYPE = "Change Room Type";

    public ChooseHotelModel(CentralModel centralModel, MainFrame frame){
        super(centralModel);
        new ChooseHotelController(this, frame);

        addRooms = new CreateRoomModel(centralModel, frame);

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
     * The Model of Manage Hotel that is created when the user clicks the Choose Hotel button
     */
    public AbstractModel manageHotel(){
        return
    }

    /**
     * The Model of Main Menu that is created when the user clicks the Cancel button
     */
    public void mainMenu(){
        new MainMenuModel(this.hotels);
    }

    /**
     * The Model of Create Reservation that is created when the user clicks the Choose Hotel button
     * @param hotel the chosen Hotel
     */
    public void createReservation(Hotel hotel){
        new CreateReservationModel(hotels, hotel);
    }

    /**
     * The Model of Enter Hotel Name that is created when the user clicks the Choose Hotel button
     */
    public void changeHotelName(){
        new EnterHotelNameModel(hotels, true);
    }

//    public void createRoom(Hotel selectedHotel){
//        new CreateRoomModel(hotels, selectedHotel, false);
//    }
//
//    public void removeRoom(Hotel selectedHotel){
//        new RemoveRoomModel(hotels, selectedHotel);
//    }
//
//    public void updateBasePrice(Hotel selectedHotel){
//        new UpdateBasePriceModel(hotels, selectedHotel);
//    }
//
//    public void removeReservation(Hotel selectedHotel){
//        new RemoveReservationModel(hotels, selectedHotel);
//    }
//
//    public void changeRoomType(Hotel selectedHotel){
//        new ChangeRoomTypeModel(hotels, selectedHotel);
//    }
}
